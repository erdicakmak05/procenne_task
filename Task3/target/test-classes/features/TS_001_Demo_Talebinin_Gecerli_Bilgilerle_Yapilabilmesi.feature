@ts_001 @demoRequest
Feature: TS_001 Demo taleplerinin, geçerli bilgiler ile gönderilebildiğini,
         eksik veya geçersiz iletişim bilgileri ile yapılamadığını ve
         kullanıcının eksik girdiler için uyarı mesajı aldığını doğrulayın.

  @tc_0001
  Scenario: Geçerli bilgiler ile başarılı olarak talep gönderilebilmesi
    Given Kullanici "ProcenneUrl" sayfasina gider
    And Kullanici Demo Request butonuna tiklar
    And Kullanici demo-request sayfasinda oldugunu test eder
    And Kullanici Name textbox'ini geçerli bilgi girer
    And Kullanici Surname textbox'ini geçerli bilgi girer
    And Kullanici Email textbox'ini geçerli bilgi girer
    And Kullanici Product dropdown menüsünden bir ürün seçer
    And Kullanici Institution textbox'ini geçerli bilgi girer
    And Kullanici Title textbox'ini geçerli bilgi girer
    And Kullanici Phone textbox'ini geçerli bilgi girer
    And Kullanici Message textbox'ini geçerli bilgi girer
    And Kullanici KVKK onayi için checkbox'i seçer
    And Kullanici Kampanyalar için mail onayi checkbox'ini seçer
    And Kullanici Captcha onayini yapar
    And Kullanici Send butonuna tiklar
    And Kullanici alert mesajinda Successful! yazdigini test eder
    And Kullanici alert ekranini onaylar.
    And Kullanici sayfayi kapatir.

    @tc_0002
    Scenario: Geçersiz email ile talep gönderilememesi

      And Kullanici "ProcenneUrl" sayfasina gider
      And Kullanici Demo Request butonuna tiklar
      And Kullanici Name textbox'ini geçerli bilgi girer
      And Kullanici Surname textbox'ini geçerli bilgi girer
      And Kullanici Email textbox'ina geçersiz bir mail adresi girer
      And Kullanici Send butonuna tiklar
      And Kullanici Email textbox'da hata mesaji aldigini test eder
      And Kullanici sayfayi kapatir.

    @tc_0003
    Scenario: Ürün seçimi yapılmadığında demo talebi gönderilememesi
      Given Kullanici "ProcenneUrl" sayfasina gider
      And Kullanici Demo Request butonuna tiklar
      And Kullanici Name textbox'ini geçerli bilgi girer
      And Kullanici Surname textbox'ini geçerli bilgi girer
      And Kullanici Email textbox'ini geçerli bilgi girer
      And Kullanici Product dropdown menüsünden urun secmez
      And Kullanici Institution textbox'ini geçerli bilgi girer
      And Kullanici Title textbox'ini geçerli bilgi girer
      And Kullanici Phone textbox'ini geçerli bilgi girer
      And Kullanici Message textbox'ini geçerli bilgi girer
      And Kullanici KVKK onayi için checkbox'i seçer
      And Kullanici Send butonuna tiklar
      And Kullanici lütfen listeden bir oge secin mesajı aldıgını test eder
      And Kullanici sayfayi kapatir.

  @tc_0003
 Scenario: Ürün seçimi yapılmadığında demo talebi gönderilememesi
    Given Kullanici "ProcenneUrl" sayfasina gider
    And Kullanici Demo Request butonuna tiklar
    And Kullanici Name textbox'ini geçerli bilgi girer
    And Kullanici Surname textbox'ini geçerli bilgi girer
    And Kullanici Email textbox'ini geçerli bilgi girer
    And Kullanici Product dropdown menüsünden urun secmez
    And Kullanici Institution textbox'ini geçerli bilgi girer
    And Kullanici Title textbox'ini geçerli bilgi girer
    And Kullanici Phone textbox'ini geçerli bilgi girer
    And Kullanici Message textbox'ini geçerli bilgi girer
    And Kullanici KVKK onayi için checkbox'i seçer
    And Kullanici Send butonuna tiklar
    And Kullanici lütfen listeden bir oge secin mesajı aldıgını test eder
    And Kullanici sayfayi kapatir.


