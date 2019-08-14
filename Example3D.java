//Alex Bell 159023006

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;
import com.sun.j3d.utils.behaviors.mouse.*;
import javax.swing.JFrame;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.TransformInterpolator;

public class Example3D extends JFrame {

    // A java 3d program to show a train made out off several different shapes
    // shapes have been rotated and translated into their positions
    // each shape has an appearance that is either a solid colour or a light reflecting colour
    // light is set up and you can see the effect on the shapes when rotating the camera around.
    // camera fixed position is moved slightly to give a good overview of the scene.
    // sky blue background added.
    // lights added to the scene.
    // basic rail added underneath the train
    // rotationinterpolators applied to all the wheels of the train that rotate indefinitely
    // objects have been added onto the track that the train would pass through.



    //The canvas to be drawn upon.
    public Canvas3D myCanvas3D;

    public BranchGroup createSceneGraph() {

        // creating the bounds of the universe
        // see mouse behaviour below



        Background myBack = new Background( );
        myBack.setColor(new Color3f(0.529f,0.807f,0.980f));

        BoundingSphere bounds =
                new BoundingSphere(new Point3d(0.0,0.0,0.0), 100);




         myBack.setApplicationBounds(bounds);

        // creating a branch group
        BranchGroup objRoot = new BranchGroup();

        // creating a transform group
        TransformGroup mainTG = new TransformGroup();
        mainTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        mainTG.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);





        Transform3D t = new Transform3D();
        //wheel one
        t.setTranslation(new Vector3d(0.0, 0.0 ,-3.0));
        TransformGroup TG1 = new TransformGroup(t);
        //wheel 2
        t.rotX(Math.PI/2);
        TransformGroup cubeTG2 = new TransformGroup(t);
        //wheel 2
        t.rotX(Math.PI/2);
        TransformGroup cubeTG3 = new TransformGroup(t);
        //wheel 3
        t.rotX(Math.PI/2);
        TransformGroup cubeTG4 = new TransformGroup(t);
        // wheel 4
        t.rotX(Math.PI/2);
        TransformGroup rot5 = new TransformGroup(t);
        // spoke 1
        t.rotX(Math.PI/2);
        TransformGroup rot6 = new TransformGroup(t);
        // spoke 2
        t.rotX(Math.PI/2);
        TransformGroup rot7 = new TransformGroup(t);
        //wheel 5
        t.rotX(Math.PI/2);
        TransformGroup rot8 = new TransformGroup(t);
        //wheel six
        t.rotX(Math.PI/2);
        TransformGroup rot9 = new TransformGroup(t);
        //spoke 3
        t.rotX(Math.PI/2);
        TransformGroup rot10 = new TransformGroup(t);
        // main cylinder rotation
        t.rotZ(Math.PI/2);
        TransformGroup cylinderrot = new TransformGroup(t);

        //rail

        t.rotZ(Math.PI/2);
        TransformGroup railrot1 = new TransformGroup(t);

        t.rotZ(Math.PI/2);
        TransformGroup railrot2 = new TransformGroup(t);


        //wheel 3
        Transform3D tt = new Transform3D();
        tt.setTranslation(new Vector3d(3,0,-3));
        TransformGroup wheel3 = new TransformGroup(tt);
        //wheel 4
        tt.setTranslation(new Vector3d(3,0,0));
        TransformGroup wheel4 = new TransformGroup(tt);
        //spoke 1
        tt.setTranslation(new Vector3d(0,0,-1.5));
        TransformGroup spokeone = new TransformGroup(tt);
        // spoke 2
        tt.setTranslation(new Vector3d(3,0,-1.5));
        TransformGroup spoketwo = new TransformGroup(tt);
        //main train box
        tt.setTranslation(new Vector3d(1.5,2.3,-1.5));
        TransformGroup box1 = new TransformGroup(tt);
        // secondary train box

        tt.setTranslation(new Vector3d(6.7,0.3,-1.5));
        TransformGroup box2 = new TransformGroup(tt);

        // wheel 5

        tt.setTranslation(new Vector3d(9,0,0));
        TransformGroup wheelfive = new TransformGroup(tt);
        // wheel 6

        tt.setTranslation(new Vector3d(9,0,-3));
        TransformGroup wheelsix = new TransformGroup(tt);
        // spoke 3
        tt.setTranslation(new Vector3d(9,0,-1.5));
        TransformGroup spokethree = new TransformGroup(tt);

        // main cylinder on train
        Transform3D cylindert = new Transform3D();
        cylindert.setTranslation(new Vector3d(6.55,2,-1.5));
        TransformGroup cylindertrans = new TransformGroup(cylindert);

        // cylinder chimney
        Transform3D cylinderchim = new Transform3D();
        cylinderchim.setTranslation(new Vector3d(2.2,5,-2));
        TransformGroup cylinderchminey = new TransformGroup(cylinderchim);

        //train track



        Transform3D railtrans1 = new Transform3D();
        railtrans1.setTranslation(new Vector3d(18,-1.8,0));
        TransformGroup railtransg1 = new TransformGroup(railtrans1);

        Transform3D railtrans2 = new Transform3D();
        railtrans2.setTranslation(new Vector3d(18,-1.8,-3));
        TransformGroup railtransg2 = new TransformGroup(railtrans2);





        //track objects
        //obj 1
        Transform3D trackob1 = new Transform3D();
        trackob1.setTranslation(new Vector3d(21.0,3.9,-4.5));
        TransformGroup trackobj1tg = new TransformGroup(trackob1);
        //obj 2
        Transform3D trackob2 = new Transform3D();
        trackob2.setTranslation(new Vector3d(21.0,9.9,-1));
        TransformGroup trackobj2tg = new TransformGroup(trackob2);

        //obj 3
        Transform3D trackob3 = new Transform3D();
        trackob3.setTranslation(new Vector3d(21.0,3.9,2.4));
        TransformGroup trackobj3tg = new TransformGroup(trackob3);






        // creating an appearance
        Appearance greenApp = new Appearance();
        Color3f greenColor = new Color3f(0.19f, 0.1f, 0.85f);
        ColoringAttributes greenCA = new ColoringAttributes();
        greenCA.setColor(greenColor);
        greenApp.setColoringAttributes(greenCA);


        Material mat3 = new Material();
        mat3.setDiffuseColor(greenColor);
        greenApp.setMaterial(mat3);

        //main train  2 apperence
        Appearance trainApp = new Appearance();
        Color3f newcolor = new Color3f(1f,1f,0.5f);
        ColoringAttributes trainCA = new ColoringAttributes();
        trainCA.setColor(newcolor);
        trainApp.setColoringAttributes(trainCA);

        Material mat2 = new Material();
        mat2.setAmbientColor(newcolor);
        trainApp.setMaterial(mat2);

        //cylinder appereance

        Appearance cylinderapp = new Appearance();
        Color3f cylindercol = new Color3f(1f,0.48f,0.027f);
        ColoringAttributes wheelCA = new ColoringAttributes();
        wheelCA.setColor(cylindercol);
        cylinderapp.setColoringAttributes(wheelCA);


        Material mat1 = new Material();
        mat1.setAmbientColor(cylindercol);
        cylinderapp.setMaterial(mat1);



        //wheel appearence


        Appearance wheelapp = new Appearance();
        Color3f colors = new Color3f(0f,0f,0f);
        ColoringAttributes wheelCA1 = new ColoringAttributes();
        wheelCA1.setColor(colors);
        wheelapp.setColoringAttributes(wheelCA1);

        Material mat = new Material();
        Color3f trycolor = new Color3f(0.619f,0.121f,0.121f);
        mat.setDiffuseColor(trycolor);
        wheelapp.setMaterial(mat);














        //track object

        Box trackobj1 = new Box(2.5f,7f,1.6f,greenApp);
        Box trackobj2 = new Box(2.5f,1f,5f,greenApp);
        Box trackobj3 = new Box(2.5f,7f,1.6f,greenApp);





        //train wheels
        Cylinder cylinder1 = new Cylinder(1.4f,0.4f,wheelapp);
        Cylinder cylinder2 = new Cylinder(1.4f,0.4f,wheelapp);
        Cylinder cylinder3 = new Cylinder(1.4f,0.4f,wheelapp);
        Cylinder cylinder4 = new Cylinder(1.4f,0.4f,wheelapp);
        Cylinder spoke1 = new Cylinder(0.1f,3f);
        Cylinder spoke2 = new Cylinder(0.1f,3f);
        Cylinder wheel5 = new Cylinder(1.4f,0.4f,wheelapp);
        Cylinder wheel6 = new Cylinder(1.4f,0.4f,wheelapp);
        Cylinder spoke3 = new Cylinder(0.1f,3f);



        // train main cylinder
        Cylinder maincylinder = new Cylinder(1.7f,5.5f,cylinderapp);

        //train chimney
        Cylinder chimn = new Cylinder(0.7f,4.5f);


        //train track
        Cylinder rail1 = new Cylinder(0.5f,40f);
        Cylinder rail2 = new Cylinder(0.5f,40f);

        //  main train box
       Box maintrain = new Box(2.3f,2.3f,1.6f,greenApp);


       //second train box under cylinder
        Box secondtrain = new Box(3f,0.3f,1.6f,trainApp);









        //scene graph
        objRoot.addChild(mainTG);




        //track objects
        mainTG.addChild(trackobj1tg);
        trackobj1tg.addChild(trackobj1);
        //track obj 2
        mainTG.addChild(trackobj2tg);
        trackobj2tg.addChild(trackobj2);
        //track obj 3
        mainTG.addChild(trackobj3tg);
        trackobj3tg.addChild(trackobj3);















            // rotating wheels
            TransformGroup wheelrotate1 = new TransformGroup();
        wheelrotate1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);



        Alpha rotationAlpha1 = new Alpha(-1, 2000);




        Transform3D rotating1 = new Transform3D();
        rotating1.rotX(-Math.PI/2);














        RotationInterpolator rotator1 = new RotationInterpolator(rotationAlpha1,
                wheelrotate1, rotating1, 0, (float) Math.PI * (2.0f));
        rotator1.setSchedulingBounds(bounds);






        //////////////////////

        TransformGroup wheelrotate = new TransformGroup();
        wheelrotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);



        Alpha rotationAlpha = new Alpha(-1, 2000);




        Transform3D rotating = new Transform3D();
        rotating.rotX(-Math.PI/2);














        RotationInterpolator rotator = new RotationInterpolator(rotationAlpha,
                wheelrotate, rotating, 0, (float) Math.PI * (2.0f));
        rotator.setSchedulingBounds(bounds);




/////////////////////////////////////////////////////////////


        TransformGroup wheelrotate2 = new TransformGroup();
        wheelrotate2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);



        Alpha rotationAlpha2 = new Alpha(-1, 2000);




        Transform3D rotating2 = new Transform3D();
        rotating2.rotX(-Math.PI/2);














        RotationInterpolator rotator2 = new RotationInterpolator(rotationAlpha2,
                wheelrotate2, rotating2, 0, (float) Math.PI * (2.0f));
        rotator2.setSchedulingBounds(bounds);




//////////////////////////////////////////////////////////////////////////////////////////////////////

        TransformGroup wheelrotate3 = new TransformGroup();
        wheelrotate3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);



        Alpha rotationAlpha3 = new Alpha(-1, 2000);




        Transform3D rotating3 = new Transform3D();
        rotating3.rotX(-Math.PI/2);







        RotationInterpolator rotator3 = new RotationInterpolator(rotationAlpha3,
                wheelrotate3, rotating3, 0, (float) Math.PI * (2.0f));
        rotator3.setSchedulingBounds(bounds);


//////////////////////////////////////////////////////////////////////////////////////////////////////

        TransformGroup wheelrotate4 = new TransformGroup();
        wheelrotate4.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);



        Alpha rotationAlpha4 = new Alpha(-1, 2000);




        Transform3D rotating4 = new Transform3D();
        rotating4.rotX(-Math.PI/2);







        RotationInterpolator rotator4 = new RotationInterpolator(rotationAlpha4,
                wheelrotate4, rotating4, 0, (float) Math.PI * (2.0f));
        rotator4.setSchedulingBounds(bounds);



//////////////////////////////////////////////////////////////////////////////////////////////////////

        TransformGroup wheelrotate5 = new TransformGroup();
        wheelrotate5.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);



        Alpha rotationAlpha5 = new Alpha(-1, 2000);




        Transform3D rotating5 = new Transform3D();
        rotating5.rotX(-Math.PI/2);







        RotationInterpolator rotator5 = new RotationInterpolator(rotationAlpha5,
                wheelrotate5, rotating5, 0, (float) Math.PI * (2.0f));
        rotator5.setSchedulingBounds(bounds);









        //test out position translation
        //////////////////////////////////////////////////////////////////////////////











        //background
        mainTG.addChild(myBack);



        //train main cylinder
        mainTG.addChild(cylindertrans);
        cylindertrans.addChild(cylinderrot);
        cylinderrot.addChild(maincylinder);


        //train box 1
      mainTG.addChild(box1);
        box1.addChild(maintrain);





      //train box 2
      mainTG.addChild(box2);
      box2.addChild(secondtrain);















        //rail
   mainTG.addChild(railtransg1);
        railtransg1.addChild(railrot1);
        railrot1.addChild(rail1);
        mainTG.addChild(railtransg2);
        railtransg2.addChild(railrot2);
        railrot2.addChild(rail2);


        //wheel one
        mainTG.addChild(TG1);
        TG1.addChild(rotator5);
        TG1.addChild(wheelrotate5);
        wheelrotate5.addChild(cubeTG2);
        cubeTG2.addChild(cylinder1);

        //wheel 2
        mainTG.addChild(rotator4);
        mainTG.addChild(wheelrotate4);
        wheelrotate4.addChild(cubeTG3);
        cubeTG3.addChild(cylinder2);


        //wheel 3

        mainTG.addChild(wheel3);
        wheel3.addChild(rotator3);
        wheel3.addChild(wheelrotate3);
        wheelrotate3.addChild(cubeTG4);
        cubeTG4.addChild(cylinder3);





        //wheel 4
        mainTG.addChild(wheel4);
        wheel4.addChild(rotator2);
        wheel4.addChild(wheelrotate2);
        wheelrotate2.addChild(rot5);
        rot5.addChild(cylinder4);


        //spoke 1
        mainTG.addChild(spokeone);
        spokeone.addChild(rot6);
        rot6.addChild(spoke1);


        //spoke 2
        mainTG.addChild(spoketwo);
        spoketwo.addChild(rot7);
        rot7.addChild(spoke2);


        // wheel five
        mainTG.addChild(wheelfive);
        wheelfive.addChild(rotator);
        wheelfive.addChild(wheelrotate);
        wheelrotate.addChild(rot8);
        rot8.addChild(wheel5);


        //wheel six
        mainTG.addChild(wheelsix);
        wheelsix.addChild(rotator1);
        wheelsix.addChild(wheelrotate1);
        wheelrotate1.addChild(rot9);
        rot9.addChild(wheel6);


        //spoke 3
        mainTG.addChild(spokethree);
        spokethree.addChild(rot10);
        rot10.addChild(spoke3);


        //chimney
        mainTG.addChild(cylinderchminey);
        cylinderchminey.addChild(chimn);




































        // Create the rotate behavior node
        MouseRotate behavior = new MouseRotate();
        behavior.setTransformGroup(mainTG);
        objRoot.addChild(behavior);
        behavior.setSchedulingBounds(bounds);

        // Create the zoom behavior node
        MouseZoom behavior2 = new MouseZoom();
        behavior2.setTransformGroup(mainTG);
        objRoot.addChild(behavior2);
        behavior2.setSchedulingBounds(bounds);

        // Create the translate behavior node
        MouseTranslate behavior3 = new MouseTranslate();
        behavior3.setTransformGroup(mainTG);
        objRoot.addChild(behavior3);
        behavior3.setSchedulingBounds(bounds);






        objRoot.compile();
        return objRoot;
    }


    // create a "standard" universe using SimpleUniverse
    public Example3D() {

        //Mechanism for closing the window and ending the program.
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myCanvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration() );
        getContentPane().add("Center", myCanvas3D);
        //Construct the SimpleUniverse:
        //First generate it using the Canvas.
        SimpleUniverse simpUniv = new SimpleUniverse(myCanvas3D);

        // *** create a viewing platform
        TransformGroup cameraTG = simpUniv.getViewingPlatform().
                getViewPlatformTransform();
        // starting postion of the viewing platform
        Vector3f translate = new Vector3f();
        Transform3D T3D = new Transform3D();
        //camera translate
        translate.set( 10.7f, 6.0f, 30.0f);
        T3D.setTranslation(translate);
        cameraTG.setTransform(T3D);

        //The scene is generated in this method.
        BranchGroup scene = createSceneGraph();
        //Add everything to the universe.
        simpUniv.addBranchGraph(scene);
        addLight(simpUniv);
        setTitle("Java 3d - Train scene");
        setSize(700,700);
        setVisible(true);

    }

    public static void main(String[] args) {

        Example3D step4 = new Example3D();

    }




    //Some light is added to the scene here.
    public void addLight(SimpleUniverse su)
    {

    /* LIGHTING --------------------------------- */

        BranchGroup bgLight = new BranchGroup();

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);

        // Set up the global lights
        // first the ambient light
        // light from all directions
        // typically use white or 'gray' light
        Color3f alColor = new Color3f(0.6f, 0.6f, 0.6f);
        AmbientLight aLgt = new AmbientLight(alColor);
        aLgt.setInfluencingBounds(bounds);
        bgLight.addChild(aLgt);

        // next the directional light
        // parallel light rays come FROM infinity TOWARDS the vector lightDir1
        Color3f lightColour1 = new Color3f(1.0f,1.0f,1.0f);
        // try out x, y and z each being + or - 1, and other coords = 0
        // with (0,1,0) the bottom of the cube should be lit
        // Vector3f lightDir1  = new Vector3f(0.0f,1.0f,0.0f);
        Vector3f lightDir1  = new Vector3f(-1.0f,0.0f,-0.5f);
        DirectionalLight light1 = new DirectionalLight(lightColour1, lightDir1);
        // light has no effect, ie Influence, outside of the bounds
        light1.setInfluencingBounds(bounds);
        bgLight.addChild(light1);

        Vector3f lightDir2  = new Vector3f(1.0f,-1.0f,0.5f);
        DirectionalLight light2 = new DirectionalLight(lightColour1, lightDir2);
        light2.setInfluencingBounds(bounds);
        bgLight.addChild(light2);

        su.addBranchGraph(bgLight);

    /* END LIGHTING --------------------------------- */

    } // ------------------ end addLight

}

