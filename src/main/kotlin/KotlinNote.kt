/*Range
for(b in 0..9){
    println(b)
}

ForEach
dizi.ForEach{
    println(it)
}

For
for (diziYazdir in dizi){
    println(diziYazdir)
}

 This bulunduğu yerdeki üst sınıfına referans verir.
 Constructor yerine sınıf parantezinin içerisine değişken tanımlayıp parametre oluşturabiliriz.
Class x(var name : String, var age : Int) Primary Constructor

 Access Levels - Erişebilirlik seviyeleri
Private -> Sadece yazılan sınıf içerisinde kullanılıp başka bir yerden erişim sağlanamaz.
Protected -> Yazılan sınıf içerisinden erişilebilir.
Internal -> Sadece kendi modülümüz içerisinden ulaşılabilir. Örn. dış bir kütüphane eklenirse oradan erişim sağlanamaz.
Public -> Her yerden ulaşılabilir.

 Fonksiyonda return kullanılacaksa fonksiyonun hangi tip döneceği girilir
private var sac = "sarı"
fun sacRengi() : String{
    return this.sac
}
println(x.sacRengi())   Başkabir yerden çağırılmak istenirse bu şekilde getirilir.
 Privite olarak atanmış bir değişkene başka bir yerden ulaşmak için bu şekilde kullanırız.
 Bu şekilde sadece okunmak üzere çağırılır, değişiklik yapılamaz.

// Null, Nullability, Null Safety
// Tanımsız
var string : String?    Null değeri alabilen String anlamına gelir. Nullable
var age : Int? = null    şeklinde de yazılabilir. Nullable
if (age != null){
    println(age * 2)
} else{
    println("Null")
}    Null safety örneği

println(age!! * 2)    !! kullanıldığı zaman kesin null bir değer gelmeyeceğini garanti ederiz. Null bir değer gelirse uygulama çöker. Null safety örneği.

 toIntOrNull vb. kullanılabilir
var sayi = editText.text.toString().toIntOrNull()    olarak yazılıp if koşulu ile null kontrolü yapılabilir.
if (sayi == null){
    textView.text = "Hata"
} else {
    textView.text "Toplam ${sayi * 5}"
}

// Elvis operatörü
val sonuc = age? * 2 ?: 10
println(sonuc)    Null geliyorsa varsayılan olarak 10'u ele al demektir. Null gelmiyorsa (age * 2) işlemi yapılır. Null safety örneği

//let
myAge?.let{it:Int
    println(it * 5)
}    myAge null ise scope a hiç girmez, çalıştırmaz. Null değilse scope'daki işlemi yapar. Null safety örneği.

 Scope-Kapsam
 Fonksiyonlar (fun) arasındaki verilere başka fonksiyondan erişilemez. Class' a tanımlanırsa değer ancak Class'ın altında bulunan tüm fonksiyonlar o veriye erişip kullanabilir.
class Main(){
    var x = " "
}
fun a(){
    x = "x"
}
fun b(){
    x = "y"
}*/

