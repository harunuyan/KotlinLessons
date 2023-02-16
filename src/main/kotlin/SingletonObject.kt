/**
 * TYPE ALİAS
 * Uzun isimlendirmelerin isimlerini kısaltıp çağırmamızı sağlar.
 *
 * typealias name = CokUzunBirİsimlendirmeOrnegi
 *
 * Main tarafında kullanılamaz. Top level kullanmak gerekir. Bu sayede tüm projeden o isimlendirme ile uzun isimli fonksiyonu çağırabiliriz.
 *
 * SİNGLETON PATTERN
 *
 * Bir class'ın nesnesine erişmek istediğimizde her zaman memory'deki aynı nesnenin döneceğini garanti eden bir tasarım şablonudur.
 * Bir class'tan sadece bir nesne oluşur ve her seferinde aynı nesneyi kullanırız.
 *
 * Singleton pattern dezavantajları ise,
 * Memoryden silinmeyen ve silinmediği için ekranlar arası veri taşıyabildiğimiz mekanizma haline dönüşüyor. Bilinçsiz kullanımda AuthOfMemoryException almamızı hızlandırır.
 *
 * @JAVA
 * Javada/Kotlinde bir class'ın hiçbir constructor'ı olmasa dahi arkaplanda boş bir public constructor'ı vardır dolayısıyla bu class'ın nesnesini oluşturabiliyoruz.
 * Eğer bu class'a parametresiz private bir constructor oluşturursak class'ın nesnesini oluşturamayız dolayısıyla class'ın sadece memory'de tek bir nesnesi olduğunu biliriz.
 * Class içerisine o class'ın nesnesini private olarak oluştururuz. Bu nesneyi geri döndüren bir public fonksiyon yazarız. dolayısıyla bu FONKSİYONA dışarıdan erişebilirsek
 * nesneye de sahip olmuş oluruz. Statik kavramı basitçe nesne oluşturmaya gerek kalmadan erişim sağlamaktır. Dışarıdan erişim olmayacak fakat class'ın üye fonksiyonuna erişebilmemiz gerekeceğinden
 * bu fonksiyonu STATİC yapmamız gerekecektir. (@Java public static Profile newInstance(){ return Profile();}) Artık class nesnesini oluşturmadan üye fonksiyona erişerek class'ın nesnesine
 * erişebiliriz. Ardından:
 * public static Profile newInstance(){
 * if(profile == null){
 *      profile = new Profile();
 *      }
 *      return profile;
 *      }
 * Fonksiyonu ilk çağırdığımızda her nesnenin default hali null olduğundan if bloğuna girip Profile nesnesini oluşturacak ve ardından her çağırımda artık null olmayacağı için
 * else case'e düşecek ve ilk if bloğunda oluşturulan profile nesnesini çağıracak. Dolayısıyla bu fonksiyon static olduğundan çağırım yaptığı field'ın da static olması gerektiğinden
 * field'ı da static olarak değiştirmemiz gerekiyor. Aynı profile nesnesini sürekli olarak geri döndürebilmeyi sağladık.
 * Çağırım Profile profile = Profile.newInstance(); şeklindedir.
 * Daha sonra profile field'ı public olduğundan erişim sağlayıp null değeri vs atayabiliriz. Field'ı da private olarak değiştirmemiz gerekecek. Private static Profile profile;
 *
 * Özet olarak;
 *      1- Class'ın bir adet constructoru olduğundan emin ol ve o constructor da boş olan default private constructor olsun.
 *      2- Class içerisinde class'ın kendisinin instance'ını değişken olarak oluştur ve bu değişkeni private static yap ve bu değişkeni geri döndürecek (return) bir fonksiyon yaz.
 *         Bu fonksiyon içeride nesnenin null olup olmadığını kontrol etsin. Null ise ilk kez erişim anlamına gelir nesneyi oluştur. Oluşturduktan sonra tekrar erişim olduğunda null olmayacağından bu oluşturulan
 *         nesneyi dön (return et). Bu fonksiyona dışarıdan erişim olacağından static olması gerekmektedir.
 *
 * Eğer birkaç yer aynı anda fonksiyonu çağıracaksa birçoğu null case'ine girebilir. Bunu önlemek için fonksiyona synchronized key word'ünü koyarız. public syncronized static profile newInstance(){ }
 * Synchronized ; yazıldığı fonksiyonun scope'unu kilitler. Birkaç thread aynı anda o fonksiyonda işlem yapacaksa ilk gireni alır diğerleri için fonksiyonu bir süre kapatır.
 * İşimizi extra sağlama almak istersek class'ın değişkeni(field) değerine de volatilekey word'ünü koyarız. private volatile static  Profile profile;
 * Volatile ; Aynı anda bu değişkene tek bir kişinin erişilebilir olmasını sağlatır. Reflection ile erişimler olduğunda işe yarayacak ektir.
 *
 * @Kotlin'de bunu yapmak için ;
 *
 * object key word'ünü kullanırız.
 *
 * object Profile {                                  // object static'e karşılık gelir.
 * var nickName : String? = null
 * }
 *
 * Erişmek için ;
 *
 * fun main {
 * Profile.nickname = "harun"
 * }
 *
 * OBJECT EXPRESSİON KULLANIMI
 *
 * Bir değişkene parametre olarak objeyi verebiliyoruz. Bunu verdiğimizde bir class'ı ya da interface'i implement edebiliriz. Arka planda cat işlemi olacağından değişkenin tipini vermek gerekiyor.
 * val fullName : User = object : Print2, User(23){ }
 *
 * Object'i expression olarak oluşturuyorsak isimsiz bir class oluşturuyoruz demektir. Tek kullanımlık bir class oluşturma ihtiyacımız varsa object expression kullanırız.
 * val fullName = object{
 * val firstName = "Harun"
 * val lastName = "UYAN"
 *
 * override fun toString() : String {
 * return "$firstName $lastName"
 * }
 * }
 *
 * İsimsiz bir class oluşturmuş oluruz ve class özelliklerinden faydalanabiliriz.
 *
 *
 * Eğer object expression kullanımı yaparken bir interface'i implement ediyorsak ya da bir class'ı extend ediyorsak değişkene tip atamak zorunda değiliz. Aynı anda kullanımlar hariç.
 *  interface print2
 *  val fullName = object : Print2{}
 *
 * 2 super type kullanımlar için tip atamak zorunda kalırız. Değişkenin class mı ya da interface mi olduğunu belirtmemiz gerekir.
 *
 * Androidde örnek bir kullanım;
 * object : CountDownTimer (100,100){
 * override fun onTick(){
 * }
 * override fun onFinish(){
 * }
 * }
 *
 * Hem interface implement alıp hem class extend alıyorsa, değişkenin tipine interface verirsek sadece interface'in fonksiyonlarını implemente edebiliriz. Class dersek de sadece class'ın fonksiyon ve değişkenlerine erişebiliriz.
 */