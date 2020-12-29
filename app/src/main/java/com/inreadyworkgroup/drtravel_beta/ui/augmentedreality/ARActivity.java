package com.inreadyworkgroup.drtravel_beta.ui.augmentedreality;

import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;
import com.inreadyworkgroup.drtravel_beta.R;

public class ARActivity extends AppCompatActivity {
    private ArFragment arFragment;
    private ModelRenderable modelRenderable;
    String Asset = "https://github.com/mrum13/objek/blob/master/pettarani.glb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_r);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        setUpModel();
        setUpPlane();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setUpModel() {
        ModelRenderable.builder()
                .setSource(this, RenderableSource.builder().setSource(this,Uri.parse(Asset),RenderableSource.SourceType.GLB)
                        .setScale(0.75f)
                        .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                .build())
                .setRegistryId(Asset)
                .build()
                .thenAccept(renderable -> modelRenderable = renderable)
                .exceptionally(throwable -> {
                    Log.i("Model","cant load");
                    Toast.makeText(ARActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
    }

    private void setUpPlane(){
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener(){
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                createModel(anchorNode);
            }
        });
    }

    private void createModel(AnchorNode anchorNode) {
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        node.setParent(anchorNode);
        node.setRenderable(modelRenderable);
        node.select();

    }
}