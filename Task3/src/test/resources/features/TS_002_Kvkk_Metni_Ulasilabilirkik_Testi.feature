@ts_002 @demoRequest
Feature: TS_002 Demo talebinde bulunan ve kisisel bilgilerini paylaşan ziyaretçinin KVKK bilgilendirmesi metnine ulaşabildiği doğrulayın.

  @tc_0004
    Scenario: Kullanıların KVKK metnine ulaşılabilmesi

    Given Kullanici "ProcenneUrl" sayfasina gider
    And Kullanici Demo Request butonuna tiklar
    And Kullanici KVKK metnine tiklar
    And Kullanici KVKK metni sayfasına gectigini test eder
    Then Kullanici yazi title'inin Demo Talebi Aydinlatma Metni oldugunu test eder
    And Kullanici sayfayi kapatir.

  @tc_0005
    Scenario: KVKK onayı alınmadan talep formu gönderilmemesi

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
    And Kullanici KVKK onayi checkbox'ini secmeden devam eder
    And Kullanici Kampanyalar için mail onayi checkbox'ini seçer
    And Kullanici Send butonuna tiklar
    And Kullanici ilerlemek istiyorsaniz bu kutuyu doldurun mesajini aldigini test eder
    And Kullanici sayfayi kapatir.
