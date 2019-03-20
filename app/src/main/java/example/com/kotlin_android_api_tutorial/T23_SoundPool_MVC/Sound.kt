package example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC

class Sound {
    var assetPath: String? = null
    var name: String? = null
    var soundId:Int = 0

    constructor(assetPath: String){
        this.assetPath = assetPath
        val components = assetPath.split("/")
        val fileName = components[components.size - 1]
        name = fileName.replace(".wav", "")
    }
}