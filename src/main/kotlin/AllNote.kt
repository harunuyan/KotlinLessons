/**
 * Bir sayı değerini val number = 100_000_000 şeklinde under score olarak yazabiliriz. Kodun çevrimi 100000000 olacaktır.
 *
 * redundant : Gereksiz.
 *
 * Top level : Herhangi bir class'ın içerisinde olmadan değişken ve fonksiyon tanımlayabilmek.
 *
 *class isimleri büyük harfle başlar, fonksiyon isimleriyse küçük başlarve camelCase ile devam eder.
 *
 * class Car constructor(wheelCount : Int, color: String = "red" ){
 * } _primary constructor(class tanımlarken yanına constructor diye belirtmemize gerek yoktur). Primary constructor tanımlayabiliriz. Duruma göre constructor yazmadan
 * direkt parametre verilebilir.
 *
 * class'ın içerisine yazdığımız diğer bir constructor ise secondary constructor'dır.
 * class Car constructor(wheelCount : Int, color: String = "red" ){
 *
 *constructor(name : String) : this(4){  _this primary constructor'a referanslıdır.
 * "secondary constructor const. created".printLog()
 *  }
 * }
 *
 * Class'a birden fazla default parametre vermek yerine secondary constructor yazmak okunabilirlik açısından daha anlamlı olabilir.
 *
 * Bir projenin nasıl ve ne sırayla çalıştığını gözlemlemek için body'lere debug koyabiliriz. Tanımadığımız bir projeyi tanımakta yardımcı olabilir.
 *
 * Bir class'ın primary constructor'unun parametrelerini verip çağırdığımızda her defasında init bloğu ilk çalışır. Parametresiz bir class çağırıldığında dahi init bloğu çalışır. Primary constructor'da olmayıp secondary
 * constructorlar'da olan parametreleri verip çağırdığımızda init bloğu tekrardan ilk olarak çalışır ve akabinde secondary constructorlara girip işleme devam eder. Çünkü tüm secondary constructorlar
 * primary constructor'ı constructor(parametre,paremetre,paremetre) : this(zorunluParametre){
 * }
 * şeklinde mecburi olarak işaret etmek zorundalardır ve primary constructor'ın zorunlu parametrelerinin this referansından sonra girilmesi gerekmektedir.
 *
 *
 * ENCAPSULATİON
 *
 *Visibility Modifiers
 *
 * Access modifier(Erişim düzenleyici) : Open ve Final'dir. Visibility m. ile karıştırılmamalıdır. Open ve Final'in görevi miras alınabilirliği ve override edilebilirliği kontrol eder.
 *
 * Java'nın aksine class'lar ve fonksiyonlar varsayılan olarak public yaratılır.
 *
 * Basitçe bir class'ın üye fonksiyonları veya üye değişkenlerine private olarak tutup, bu değişkenlere erişilebilecek fonksiyonları public tutmak.
 *
 * Privite değişkenler bağlı bulunduğu class içerisinde kullanılabilir.
 *
 * Protected veri kendi içerisinde ve miras alınan yerde kullanılır. Kendi class'ı ve child class'larına publictir fakat dışarıya private'dır. Top level tanımlamalarda kullanılamaz
 * çünkü child class'ı olamaz.
 *
 * Internal ise sadece kendi ve bağlı olduğu modüllerde çalışır. Örn. Src gibi yeni bir modül oluşturduğumuzda srcdeki internal değişkenleri ve fonksiyonları kullanamayız.
 *
 * Private olan bir değişkenin değerini okumak istersek o değişkene get- yazmak gerekir. fun getName() : String{ return name }
 *
 * Kotlinde field'lar yok property'ler vardır. kotlinde public bir değişken tanımlasak dahi makine kodu private bir değişken olarak tanımlar ve public get, set fonksiyonlarıyla birlikte yazdırır.
 *
 * Kotlinde private bir değişken tanımlandığında makine kodunda get ve setleri yazılmaz. Kotlinde her tanımladığımız değer private değer olarak yazılır değişen tek şey get ve set fonsksiyonlarının
 * yazılıp yazılmamasıdır. O yüzden kotlinde bir class altına tanımladığımız değişkenler property'dir.
 *
 * class BankAccount{
 * var balance = 100_000
 *
 * set (value){
 * field = value // field = backing field
 * }
 * }
 *
 * Bir değişkenin değiştirilmesini istiyorsak private set olarak belirtmeliyiz.
 * class BankAccount{
 *  * var balance = 100_000
 *  *
 *  * private set (value){
 *  * field = value // field = backing field
 *  * }
 *  * }
 *
 * INHERİTANCE
 *
 * Kotlinde tüm classlar varsayılar olarak final'dir. Bir class'ı miras alabilmek için open class şeklinde yazarız. Child class ise class a () : B(){} şeklinde tanımlanır.
 *
 * Miras aldığımız zaman miras alınan class'ın eğer varsa parametrelerini vermeliyiz.(primary veya secondary constructor) a () : B(zorunluParametre){}
 *
 * Miras aldığımız class içerisinde private değer varsa ona erişemeyiz, protected ve internal değerlere erişebiliriz.
 *
 * Bir değişkeni ya da fonksiyonu open olarak yazdığımızda override edebiliriz.
 * open var name = ""
 * open fun name(){}
 *
 * İki class'tan " : " ile miras alınamaz. İnterface verilebilir. Multiple inheritance üst class'tan miras alan bir class'ı miras alırsak mümkündür. İki üst class'ın da fonksiyon ve değişkenlerini kullanabiliriz.
 *
 * Override : Üst class'ta tanımlanan bir değeri ve bir iş yapan fonksiyonu değiştirebilmek. Open ile yazıldıysa mümkündür.
 *
 * Polymorphism(Çok biçimlilik) : Basitçe üst class'ta yazılan bir fonksiyon veya değişkenin yaptığı işi değiştirmektir. Örn. Miras alınan bir fun calculator(){} fonksiyonunu alt class'ta override
 * edip fonksiyonun body'sini değiştirip yeni bir görev tanımlamak bir polymorphism'dir.
 *
 * Super key word'ü üst classtaki fonksiyonu işaret eder. super.calculator()
 *
 * Override edeceğimiz bir fonksiyon üst class'taki aynı işlevi yapsın ama ufak eklemeler yapacağım diyorsak super ile çağırırız. Bu sayede hem üst class'taki işlevini yapar hem de
 * override ile kendi değişikliklerimizi yapmış olur.
 * Override edilen bir fonksiyona final koyarsak o fonksiyon başka bir child class'a override edilemez fakat çağırılabilir. final override fun calculator(){}
 *
 * Üst class'ta bulunan open bir fonksiyonun aynısını alt class'ta tanımlayamayız. Onun yerine üst class'ta open tanımlandıysa override etmek gerekir. Open tanımlanmadıysa aynı fonksyionu
 * tanımlayıp kullanabiliriz. Çağırdığımızda ise this. ile o fonksiyonu çağırdığımızı belirtmemiz gerekir. (this. bağlı olduğu class'ı işaret ettiğinden üst class'taki fonksiyonu görmeyecektir)
 *
 * ABSTRACT
 *
 * Abstract class bir sözleşmedir. Child class'larda olmasını istediğimiz zorunlu fonksiyonları abstract class'larda toplarız. Bu sayede child classlarda daha az kod yazarak daha fazla iş yaparız.
 *
 * Abstract bir değişken oluşturulurken değer ataması yapamayız, default değeri olamaz. abstract val fridge : Fridge
 *
 * Abstract fonksiyonlarda body olmaz dolayısıyla scope açılmaz. abstact fun clean (clock : Int) : Unit
 * Abstract bir class'ın içerisinde ody'sini yazabildiğimiz bir fonksiyon eklemek istersek fonksiyonun başına open yazıp abstract yazmayız. open fun makeCoffee(){}
 *
 * Open bir class içine abstract bir fonksiyon yazamayız.
 *
 * Kısaca abstract ne yapması gerektiyle değil ne olması gerektiğiyle ilgilenir.
 *
 * abstract key word'ü open olabilmesini sağladığından miras alınabilmeyi de sağlar. Dolayısıyla fonksiyonlar ve değişkenler override edilebilir. Override edilmeden de çağırılabilir.
 * Bir abstract class başka bir abstract class'ı miras alabilir.
 *
 * Düz bir class abstract class'ı miras alırsa içindekileri override etmesi gerekir. abstractlar arası miras ilişkisinde bu durum geçerli değildir.
 *
 * abstract class McDonalds{}
 * absract class McDonaldsExpress : McDonalds() {}
 *
 * final ve open kullanılamaz. Anlamsızdır.
 * Miras veren abstract class fonksiyonu final yaparsa child class o fonksiyonu override edemez. final abstract fun clean()
 *
 * Infix abstract fonksiyon oluşturabiliriz. abstract infix fun clean(time : Int)
 *
 * Extention fonksiyon oluşturabiliriz. abstract class mcDonaldsExpress : McDonald(){} --- infix fun McDonaldsExpress.print(message : String){} - hem infix hem extention
 *
 * Abstract class'ları bir sözleşme olarak düşündüğümüz ve tanımlama yapamdığımız için zorunlu olmadıkça open ifadeler ve düz val, var değişkenleri ve fonksiyonları tanımlamamak gerek.
 *
 * Eğer bir abstract class birden fazla yerde kullanılıyorsa ve sadece bir class'a ekleme yapmak istiyorsak abstract class içerisine open fun tanımlamak yerine bu abstract class'ı
 * miras alan bir abstract class açıp oraya o fonksiyonu ekleyebiliriz.
 * abstract class McDonaldsExpress : McDonalds (){
 * abstract fun sellCoffee() : McCoffee
 * override fun clean(clock : Int){
 * println("Clean time $clock")
 * }
 * }
 *
 * Abstract bir class'ı miras alan abstract bir class'ı düz bir class miras aldığında child abstract class'ta override edilen öğeleri child düz class almak zorunda değildir.
 * Üst abstract classta zorunlu olarak almayı istemediğimiz bir fonksiyonu vs, bu class'ı miras alan child abstract classta override edersek child abstract class'ı miras alan düz class
 * bu fonksiyonu almak zorunda değildir. Sebebi override edilen fonksiyonun body'sinin olması. Fonksiyon open fonksiyonmuş gibi davranacaktır. Hiç override edilmemesini istediğimiz yapıya
 * yine final key word'ü koyarak fonksiyonu kilitleyebiliriz.
 *
 * Abstract class'ı main tarafında direkt çağıramayız. abstract classı miras alan düz bir fonksiyonu çağırabiliriz.
 *
 * abstract class a
 * class b : a(){}
 *
 * fun main(){
 * val a1 = b()
 * }
 *
 *
 * Open class ile abstract class birbirine benzer. Farkı open class'ta override zorunlu tutulmaz. Abstract class'ta ise belli kurallar dışında override zorunlu. Open class'ın nesnesi oluşturuşurken
 * abstract class'ın nesnesi oluşturulamaz.
 *
 *
 * INTERFACE
 *
 * INTERFACE kısaca bir yetenek setidir.
 *
 * Abstract class'lardan en büyük farkı interface'lerin state tutamıyor oluşlarıdır. Yani içerisinde bir değişken tanımlayıp o değişkende veri saklayamıyoruz.
 * Abstract class'larda ise düz fonksiyonlar ve tanımlamalar oluşturup değer atayabiliriz.
 *
 * interface MyInterface{
 * val prop : Int //Abstract
 *
 * val propertyWithImplementation : String
 *      get() = "Foo"
 *      } // Bu değer atamak değildir,
 *      fun getPropertyWithImplementation() : String{
 *                            return "Foo"  }    olarak yazmaktır. Bu bir değişken değil property'dir ve sadece geri değer döndüren bir fonksiyon yazmış oluyoruz. State tuttuğu
 *                                               anlamına gelmez çünkü değerini değiştiremiyoruz. Bu yazım override zorunluluğunu ortadan kaldırır.
 *
 * Class'lar miras(extend) alınır interface'ler implemente edilir.
 *
 * Final ve open interface yazmak anlamsızdır.
 *
 * Abstract class child calss'ının nelere sahip olacağını belirtirken bir class'ın bir interface'e sahip olması demek kendi beceri setini, yapabildiklerini arttırıyor demektir.
 * Kısaca biri sözleşme biri neleri yapabileceğini söyler. (Abstract/Interface)
 *
 * Interface fonksiyonları herhangi bir class'ın içerisindeki bir yapıya ihtiyaç duymazlar. Basitçe bir yerden tetiklenmeyi beklerler. Implemente edildiği yerlerde de ayağa kalkmayı beklerler.
 * Interface'ler bir yerden tetiklenir ve tetiklendiğinin bilgisini alır.
 *
 * Hatırlatma : ABSTRACT class'lada open fonksiyon yazmamızın anlamı miras alan tüm child class'larda bu fonksiyonu override etmeyeceğimizdir.
 * Bunun doğru yazımı ise bu class'ı miras alan bir bir abstract class oluşturmamız ve fonksiyonu oraya yazmamız olacaktır.
 * Bir yerden tetikleyip başka bir yerden çalıştığının bilgisini almak istiyorsak INTERFACE olarak yazmalıyız.
 *
 * Interface içerisine yine body'si olmayan abstract tanımlama yapabiliriz fakat pek kullanışlı olmayacaktır.
 *
 * INTERFACE'de body si olan bir fonksiyon yazarsak overide zorunluluğu kalkar. Body'siz bir fonksiyonu override etmemiz gerekiyor. Doğru kullanım için abstract class'ta yaptığımız gibi
 * interface'i implemente eden interface yaratıp body'si olan fonksiyonu oraya tanımlarsak override zorunluluğu yine ortadan kalkmış olur. Yine super. key word'ü kullanılarak üst interface'deki
 * fonksiyon da çağırılabilir.
 *
 * Dinamik olarak değiştirilebilen tanımlar state tutabilir anlamına gelir ve interface'te kullanılamazlar. Dinamik olarak değiştirelemiyorsa örn. return "örnek" gibi dönüş değerli
 * tanımlar interface içerisine yazılabilir.
 *
 * Bir interface'i implemente etmek istiyorsak yine abstract'da olduğu gibi : kullanılır. ( : ). İnterface aralarına virgül koyulur. class A() : MyInterface, MyInterface2
 *
 * Kotlin'de sadece bir classı extend edebiliriz ama birden fazla interface'i implemente edebiliriz.
 *
 * Bir interface başka bir interface'i miras alabilir.
 *
 * Bir interface başka bir interface'i implement ediyorsa ve override edilmesi zorunlu fonksiyonu override ettiyse başka bir class'ta bu interface kullanıldığında o fonksiyonu override etme zorunluluğu ortadan kalkar.
 *
 * ABSTRACT class'larda olduğu gibi, INTERFACE başka bir INTERFACE'i implement ediyorsa override zorunluluğu olmaz.
 *
 * Eğer bir Abstract class bir interface'i implement ediyorsa o interface'in override edilmesi zorunlu fonksiyonlarını override etmeyebilir. ABstract classlar için bu opsiyoneldir.
 *
 * Override edilen, Body'si olmayan bir fonksiyonun super'i çağırılamaz.
 *
 * class A : B() , C , D { } Parametre parantezi olanlar class extend etmiştir. Parantezi olmayanlar interface implemente etmiştir.
 *
 * Eğer implemente edilen 2 interface'de de aynı fonksiyonlar var ise bu durumda body'leri olsa da override edilmeleri zorunludur.
 * class A : B() , C , D {
 * override fun foo(){
 * super<C>.foo()
 * super<D>.foo()
 * }}                  sadece super.foo yapsaydık C mi D mi olduğunu anlamayıp uyarı verecekti.
 *
 * Özetle,
 *       BENZELİKLERİ(Interface/Abstract)
 *       * İkisinde de body'si ve property, geri dönüş değeri olmayan override olmak zorunda, aksi halde override zorunluluğu vardır.
 *       * Bir abstract class başka bir abstract class'ı miras alıyorsa override zorunluluğu ortadan kalkar. Interface'de de aynı mantık geçerlidir.
 *       * Child abstract class'ta ve interface'de override zorunluluğu olmayan bir fonksiyonu veya property'i override etmişsek düz bir class'a implement veya extend edildiyse
 *         override zorunluluğu ortadan kalkar.
 *       * Eğer body'si varsa düz bir fonksiyonun override edilmesi opsiyoneldir.
 *       * İkisi de super type olarak kullanılırlar. Parametre tipi olarak belirtilebilirler.
 *       FARKLILIKLARI
 *       * Interface state tutmazken abstract state tutabilir.
 *       * Abstract class'lar class'tır ve bir class sadece bir abstract class miras alabilir. Bir class birden fazla interface implemente edebilir.
 *       * Abstract class'larda bir class'ta olmasını istediklerimizi yaparız, Interface'lerde ise bir class'a yeni bir özellik ekleriz.
 *
 * val car = Array<Double>(size: 5){it:Int
 *  3.14 * it
 *  }       <> kısmı da bir interface'dir. Bir arayüz belirteci olarak da interface'i kullanabiliriz.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */