@ts_004 @demoRequest
Feature: TS_004 Demo talebi yapacak olan Kullanıcıler için, Captcha sisteminin aktif olduğunu doğrulayın.
  @tc_0008
  Scenario:Demo talebi yapacak olan Kullanıcıler için, Captcha sisteminin aktif olması
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
    And Kullanici Kampanyalar için mail onayi checkbox'ini seçer
    And Kullanici Send butonuna tiklar
    And Kullanici alert mesajinda Lutfen recaptchayi isaretleyin yazdigini test eder
    And Kullanici sayfayi kapatir.

