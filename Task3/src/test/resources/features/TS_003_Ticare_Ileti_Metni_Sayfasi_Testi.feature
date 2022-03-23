@ts_003 @demoRequest
  Feature: TS_003 Ticari mailler almak istemesede kullanıcılıların demo talebi yapabileceğini
           ve Ticari Elektronik İleti İzni metnine ulaşabildiğini doğrulayın.

@tc_0006
  Scenario: Ticari mail almak istemese de kullanıcının demo talebi yapabilmesi

  Given Kullanici "ProcenneUrl" sayfasina gider
  And Kullanici Demo Request butonuna tiklar
  And Kullanici Name textbox'ini geçerli bilgi girer
  And Kullanici Surname textbox'ini geçerli bilgi girer
  And Kullanici Email textbox'ini geçerli bilgi girer
  And Kullanici Product dropdown menüsünden bir ürün seçer
  And Kullanici Institution textbox'ini geçerli bilgi girer
  And Kullanici Title textbox'ini geçerli bilgi girer
  And Kullanici Phone textbox'ini geçerli bilgi girer
  And Kullanici Message textbox'ini geçerli bilgi girer
  And Kullanici KVKK onayi için checkbox'i seçer
  And Kullanici Kampanyalar için mail onayi checkbox'ini secmeden devam eder
  And Kullanici Send butonuna tiklar
  And Kullanici alert mesajinda Lutfen recaptchayi isaretleyin yazdigini test eder
  And Kullanici alert ekranini onaylar.
  And Kullanici sayfayi kapatir.

  @tc_007
  Scenario: Ticari Elektronik İleti İzni metnine ulaşılabilmesi
    Given Kullanici "ProcenneUrl" sayfasina gider
    And Kullanici Demo Request butonuna tiklar
    And Kullanici Ticari Elektronik ileti izni  metnine tiklar
    And Kullanici Ticari Elektronik ileti izni metni sayfasına gectigini test eder
    Then Kullanici yazi title'inin Ticari Elektronik ileti izni oldugunu test eder
    And Kullanici sayfayi kapatir.