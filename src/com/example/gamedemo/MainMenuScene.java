package com.example.gamedemo;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import org.andengine.engine.camera.Camera;

import com.example.gamedemo.SceneManager.SceneType;

public class MainMenuScene extends BaseScene
{
	private MenuScene menuChildScene;
	private final int MENU_PLAY = 0;
	private final int MENU_OPTIONS = 1;

	private void createBackGround()
	{
		attachChild(new Sprite(400, 240, resourcesMagager.menu_background_region, vbom)
		{
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera)
			{
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	private void createMenuChildScene()
	{
		menuChildScene = new MenuScene(camera);
		menuChildScene.setPosition(400, 240);

		final IMenuItem playMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_PLAY,
				resourcesMagager.play_region, vbom), 1.2f, 1);
		final IMenuItem optionsMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_PLAY,
				resourcesMagager.options_region, vbom), 1.2f, 1);

		menuChildScene.addMenuItem(playMenuItem);
		menuChildScene.addMenuItem(optionsMenuItem);

		menuChildScene.buildAnimations();
		menuChildScene.setBackgroundEnabled(false);

		playMenuItem.setPosition(playMenuItem.getX(), playMenuItem.getY() + 10);
		optionsMenuItem.setPosition(optionsMenuItem.getX(), optionsMenuItem.getY() - 110);

		menuChildScene.setOnMenuItemClickListener((IOnMenuItemClickListener) this);
		setChildScene(menuChildScene);

	}

	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX,
			float pMenuItemLocalY)
	{
		switch (pMenuItem.getID())
		{
			case MENU_PLAY:
				return true;
			case MENU_OPTIONS:
				return true;
			default:
				return false;
		}
	}

	@Override
	public void createScene()
	{
		createBackGround();
		createMenuChildScene();
	}

	@Override
	public void onBackKeyPressed()
	{
		System.exit(0);
	}

	@Override
	public SceneType getSceneType()
	{
		return SceneType.SCENE_MENU;
	}

	@Override
	public void disposeScene()
	{

	}

}
