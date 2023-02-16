/* Git
cd = change directory
Çalışılacak klasörde sağ tık ile git bash here denildiğinde o klasör ile çalışılır.
Aksi takdirde -cd komutu ile git ile çalışılacak hedef klasör yolu seçilmelidir.
-git init komutu ile çalıştırılır. Gizli bir .git dosyası eklenir. Silinmemesi gerekir.
-git status komutu : Bulunduğu ve altı klasörlerin içerisinde dosyaların ne durumda olduğunu gösterir. Kırmızı renkte gözükenler git tarafından takip edilmiyor demektir. Default olarak dosyalar kontrol edilmez. Manuel olarak -git add * komutunu kullanırsak tüm klasörler git tarafından kontrol ve takip edilebilir.
Tekrardan -git status yapıldığında az önce kırmızı gözüken tüm dosyaların yeşile döndüğünü ve artık git tarafından takip edildiğini görürüz. Değişiklikleri local olarak takip edebiliriz.
Tüm dosyaları git ile kontrol etmek istemiyorsak farklı -git add komutlarını kullanabiliriz.
örn. -git add *.txt : Yalnızca txt uzantılı olanları kontrol et.
örn. -git add "dosya yolu". Zaten seçili dosya üzerinde çalışılıyorsa sadece -git add "proje.txt" : Yalnızca hedef gösterdiğim dosyayı takip et.
Klasöre yeni dosya eklendiğinde -git status ile kontrol edildiğinde git tarafından takip edilmez. Manuel olarak eklenilmesi gerekir.
-git commit -m "YORUM" ile değişiklikler saklanır.
-git log ile de kim tarafından hangi dosyaya değişiklik yapıldığı görülebilir.

-git config --global user.name komutu ile hangi kullanıcı adı ile loglara kayıt olacağımızı görebiliyoruz.
-git config --global user.name "yeniKullanıcıAdı" ile loglardaki kullanıcı adımızı değiştirebiliriz.
Aynı şekilde user.email' i de değiştirebiliriz.

-git diff komutu ile değişiklikleri görürüz
-git add * ile değişiklikleri staged area'ya yollayabiliriz. Bu sayede -git status komutu yazıldığındadeğişiklikler görülmez.
-git diff --staged ile, staged area'ya kaydedilen değişiklikleri yeniden görebiliriz.
-git log mevcut klasör içerisinde atılan tüm logları döker.

Mevcut değişikliği sadece Commit yapıp Push yapmadan github'da göremeyiz. Push ile güncellemeyi server'a göndeririz.
Github'dan seçtiğimiz bir projenin dosyasını kopyalayıp kendi bilgisayarımızda klonlamak istediğimiz dosyaya sağ tıklayıp "git bash here" seçeriz ve ardından komut satırına -git clone kopyaladığımızLink şeklinde cihazımıza indiririz.

Yanlışlıkla rollback yapıldığında geri getirmenin yolu idea üzerine sağ tıklayıp Local history de rollback geçmişimizi görmektir.

 */