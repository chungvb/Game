package com.example.gamedemo;

import com.example.gamedemo.SceneManager.SceneType;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.app.Activity;

public abstract class BaseScene extends Scene
{
	// --------------------------------------------
	// VARIABLES
	// --------------------------------------------

	protected Engine engine;
	protected Activity activity;
	protected ResourcesManager resourcesMagager;
	protected VertexBufferObjectManager vbom;
	protected Camera camera;

	// --------------------------------------------
	// CONSTRUCTOR
	// --------------------------------------------

	public BaseScene() {
		this.resourcesMagager = ResourcesManager.getInstance();
		this.engine = resourcesMagager.engine;
		this.activity = resourcesMagager.activity;
		this.vbom = resourcesMagager.vbom;
		this.camera = resourcesMagager.camera;
		createScene();
	}

	// --------------------------------------------
	// ABSTRACTION
	// --------------------------------------------

	public abstract void createScene();

	public abstract void onBackKeyPressed();

	public abstract SceneType getSceneType();

	public abstract void disposeScene();

}
