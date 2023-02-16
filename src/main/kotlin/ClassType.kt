/**
 * DATA CLASS
 *
 * value tutabildiğimiz ve o value'lara ait özel fonksiyonların(equals, hashCode, toString, copy) arkaplanda default olarak yazıldığı ve o fonksiyonları özelleştirebildiğimiz class'lardır.
 * Bunun yanında parametre sayısı kadar component oluşturarak destructuring declarations kullanımını yapabilmeyi sağlar ve okunabilirliği önemli ölçüde iyileştirir.
 *
 * data class A (
 * val example : String
 * ){
 * } şeklinde tanımlanırlar.
 *
 * En az bi parametreye sahip olmak zorunda ve parametreler val, var ile tanımlanmak zorundadır.
 *
 * OPEN, ABSTRACT , sealed ve inner class yapılamaz. MİRAS VEREMEZ fakat MİRAS ALABİLİR(Super type olamaz).
 * class A {}
 * class DataClass(val name : String, val surName : String) : A {}
 *
 * Tüm data classlar varsayılan olarak FINAL'dir. Başına access modifier olarak final eklememiz gereksiz olacaktır. "Redundant"
 *
 * equals, hashCode, toString, copy, componentN fonksiyonlarını arka planda default olarak oluştururlar. Bu fonksiyonları override ederek kendimiz de
 * özelleştirebiliriz. Bu sayede default fonksiyonları değil kendi yazdıklarımızı çalıştıracaktır.
 * override fun toString() : String {
 *      return "return super.toString()"
 *      }
 *
 *
 *
 * Bu şekilde constructor parantezi dışında tanımladığımız bir değer varsa varsayılan olarak tanımlanan equals, hashCode, toString, copy, componentN haricinde olacaktır.
 * Arka planda oluşturulan bu fonksiyonlar sadece constructor'ı kapsar.
 *
 * data class News(
 *  val title : String = "Title",
 *  val description : String,
 *  val hasMediaContent : Boolean,
 *  val mediaList : List<Media>
 * ){
 *  val relatedNewsList : List<News> = arrayListOf() // Arkaplanda oluşturulan fonksiyonlara dahil değildir.
 *  }
 *
 *
 *  val(title, description, hasMediaContent, mediaList) = News
 *  val(title1, description1) = News
 *  Buna Destructuring declarations denir. News data class'ından referans alınıp kullanılabilirler.
 *  title ve title1 diye değişkenlerimiz var demektir artık. news.mediaList yerine direkt mediaList kullanabiliriz değerleri aynı olacaktır.
 *  İsimlendirme component1, component2 şeklinde olabilir. val(component1, component2, component3, component4)
 *  Data class olan her şeyi destructuring declarations olarak kullanabiliriz.
 *
 *
 *
 *
 * Düz class ile data class'ın farkı. Data class'ta primary constructor'daki değerlerin equals, hashCode, toString, copy, componentN fonksiyonları oluşturulur. Düz class'ta kendimiz
 * tanımlamak zorunda kalırız.
 *
 *      equals : Değişkenleri karşılaştırmak(value karşılaştırması)
 *      hashCode : Bu classların oluşturduğu bir hashCode Stringi vardır. Elimizdeki objenin elimizdeki başka bir objenin birebir aynı olup olmadığını karşılaştırır. Value'den ziyade objeler karşılaştırılır.
 *      toString : Class'ın içerdiği verileri istediğimizde
 *      copy : Bahsi geçen class'ın birebir aynısını oluşturmak
 *
 *
 *
 * Data classlar bu şekilde copy kullanımına olanak sağlar.
 * val newsOne = news.copy(description = "Farklı description")
 *
 * val newsOne = News(
 *      title = news.title,
 *      description = "Farklı description",
 *      hasMediaContent = news.hasMediaContent,
 *      mediaList = news.mediaList
 *      )  şeklinde yazmak zorunda kalmayız.
 *
 *
 *
 *
 *
 * Düz class'ta toString tanımlamadan o class'tan çıktı almak istersek bize memory'deki adresini verecektir. Özel olarak toStrig fonksiyonu tanımlamamız gerekecektir. Data
 * class'ta özel olarak tanımlamak opsiyoneldir.
 *
 *
 *
 *
 * ENUM CLASS
 *
 * Tip güvenliği (Type safety sağlar).
 *
 * Kullanım amacı aynıveri kümelerinin gruplanabilir olmasını sağlar.
 *
 * Opsiyonların tamamının neler olduğunu görebilmemizi sağlar.
 *
 * Yine data class gibi yapısı gereği abstract, open, inner ve sealed olamazlar. Default olarak final class'tırlar başına finall tanımı yapmak yine gereksizdir -Redundant-
 *
 * Özünde class olduğundan constructor kullanabilirler ve constructor içlerinde veri tutabilirler.
 *
 * Enum class'ların nesnesini OLUŞTURAMAYIZ.
 *
 * Her enum class'ı final name : String ve final ordinal : Int değişkenlerine DEFAULT OLARAK SAHİPİRLER.
 * Name ifadesi, Enum'ın kendi String halini verir.
 * Ordinal ifadesi, Enum'daki sabitin indexini verir ve 0 ' dan başlar.
 * Bu değişkenler FİNAL olduklarından enum sabitleri içerisinde OVERRİDE EDİLEMEZLER.
 *
 * Herhangi bir class'ı miras alamazlar, INTERFACE implemente edebilirler.
 * Enum class'lar abstract property ve abstract fonksiyonlar alabilirler fakat bunları aldıklarında tüm sabitler bu abstract yapıyı override etmek zorundadırlar.
 *
 * Open fonksiyon yazılabilir ve override zorunluluğu yoktur, body tanımlanmalıdır.
 *
 * Enum sabitlerinin ismi BÜYÜK HARFLERLE YAZILIR.
 * enum class ColorType{
 * RED, BLUE, WHITE, GREEN
 * }
 *
 *
 *
 * Aşağıdaki Teams, tüm enum sabitlerinin üst class'ıdır.
 * enum class Teams(val starCount : Int) : TeamsFunctipnality{      //Enum classlar parametre alabilir. Burda val olarak tanımlamamızın sebebi dışarıdan kolayca erişebilmek.
 * FENERBAHÇE(starCount: 3),
 * GALATASARAY(starCount: 4),
 * BEŞİKTAŞ(starCount: 3),
 * TRABZONSPOR(starCount: 2)
 * }
 *
 * Enum sabitleri class olarak tutulur. Enum class'ında parametre varsa sabitler de aynı parametreye sahip olacaktır.
 *
 * Tüm enum sabitleri enum class'ını arkaplanda miras alır.
 *
 *
 *
 *
 *
 * INLINE CLASS - VALUE CLASS
 *
 *
 * Sadece bir parametre alabilir.
 * @JvmInline
 * value class A(val name : String){} şeklinde tanımlanır.
 *
 * Inline class'lar init bloklarını kullanabilirler
 *
 * Inlıne class'ların belirtilen constuctorları javada private olarak tutuluyor ve bundan dolayı nesneleri oluşturulamıyor.
 *
 * Miras alamaz ve veremezler. Default olarak finaldir.
 *
 * İçerisine property tanımlanabilir ancak backing field' i olamaz.
 *
 *
 *
 *
 *
 *
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