var scene = new THREE.Scene();
var aspectRatio = window.innerWidth / window.innerHeight;
var camera = new THREE.PerspectiveCamera(30, aspectRatio, 0.1, 10000);
camera.position.z = 20;
var renderer = new THREE.WebGLRenderer();
renderer.setSize(window.innerWidth, window.innerHeight);
renderer.setClearColor(0x333333);

var clock = new THREE.Clock();
var time = 0;
var earthOrbitRadius = 100,
    earthOrbitAngle = 0
earthOrbitSpeed = 0.5;
document.body.appendChild(renderer.domElement);

var group = new THREE.Object3D();


scene.add(new THREE.AmbientLight(0x333333));

var ambientLight = new THREE.AmbientLight(0xFFFF99);
scene.add(ambientLight);

var light = new THREE.PointLight(0xFFFFFF, 1, 0);
light.position.set(0, 0, 0);
scene.add(light);

THREE.ImageUtils.crossOrigin = 'anonymous';

var geometry = new THREE.SphereGeometry(2, 64, 64);
var texture = THREE.ImageUtils.loadTexture("../5vnqqbeu/2_no_clouds_16k.jpg");
var bumpTexture = THREE.ImageUtils.loadTexture('../5vnqqbeu/elev_bump_16k.jpg');
var specularTexture = THREE.ImageUtils.loadTexture('../5vnqqbeu/water_16k.png');

var material = new THREE.MeshPhongMaterial({
    color: 0xaaaaaa,
    ambient: 0xaaaaaa,
    specular: new THREE.Color('grey'),
    specularMap: specularTexture,
    map: texture,
    bumpMap: bumpTexture,
    bumpScale: 0.2,
    shininess: 10
});

var earth = new THREE.Mesh(geometry, material);
//earth.rotation.z = 23.439281 * Math.PI / 180;
group.add(earth);
scene.add(group);

function render() {
    requestAnimationFrame(render);

    var delta = clock.getDelta();
    group.rotation.y += 1 * delta;

    var time = clock.getElapsedTime() * 0.5;
    //group.position.x = Math.cos(time) * 5;
    // group.position.z = Math.sin(time) * 5;

    renderer.render(scene, camera);
}

render();