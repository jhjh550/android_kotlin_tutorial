package example.com.kotlin_android_api_tutorial.T25_Json

class JsonDTO{
    var name:String = ""
    var tel:String = ""
    var age:Int = 0

    constructor(name:String, tel:String, age:Int){
        this.name = name
        this.tel = tel
        this.age = age
    }

    override fun toString(): String {
        return "name : "+name+" tel : "+tel+" age : "+age
    }
}