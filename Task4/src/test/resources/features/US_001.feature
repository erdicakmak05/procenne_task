@us_01
Feature: US01 Demoqa Form Sayfası Pozitif Negatif Testler
  @tc_01
  Scenario: TC_01 Kullanıcının zorunlu alanları doldurarak başarılı olarak formu onaylayabilmesi
    Given Kullanici "Url"'e gider
    And Kullanici Name textbox'ini girer
    And Kullanici eposta adresini girer
    And Kullanici cinsiyet'ini secer
    And Kullanici telefon numarasini girer
    And Kullanici dogum tarihini secer
    And Kullanici subjects textbox'ini girer
    And Kullanici hobi checkbox'ini secer
    And Kullanici resim ekler
    And Kullanici adress textbox'ini doldurur
    And Kullanici eyalet secer
    And Kullanici sehir secer
    And Kullanici submit butonuna tiklar
    Then Kullanici basarili olarak kayit gonderdigini test eder
    And Kullanici sayfayi kapatir

  @tc_02
  Scenario: TC_02 Kullanıcın geçersiz email adresi ile kayıt gönderememesi
    Given Kullanici "Url"'e gider
    And Kullanici Name Surname textbox'ini bos birakir
    And Kullanici eposta adresini girer
    And Kullanici cinsiyet bolumunde secim yapmaz
    And Kullanici telefon numarasini girer
    And Kullanici dogum tarihini secer
    And Kullanici subjects textbox'ini girer
    And Kullanici hobi checkbox'ini secer
    And Kullanici resim ekler
    And Kullanici adress textbox'ini doldurur
    And Kullanici eyalet secer
    And Kullanici sehir secer
    And Kullanici submit butonuna tiklar
    Then Kullanici eksik bilgiler ile kayit gonderilemedigini test eder
    And Kullanici sayfayi kapatir

  @tc_03
  Scenario: TC_03 Kayit Olma Testi
    Given Kullanici "Url"'e gider
    And Kullanici Name textbox'ini girer
    And Kullanici gecersiz email adresi girer
    And Kullanici cinsiyet'ini secer
    And Kullanici telefon numarasini girer
    And Kullanici dogum tarihini secer
    And Kullanici subjects textbox'ini girer
    And Kullanici hobi checkbox'ini secer
    And Kullanici resim ekler
    And Kullanici adress textbox'ini doldurur
    And Kullanici eyalet secer
    And Kullanici sehir secer
    And Kullanici submit butonuna tiklar
    Then Kullanici eksik bilgiler ile kayit gonderilemedigini test eder
    And Kullanici sayfayi kapatir
