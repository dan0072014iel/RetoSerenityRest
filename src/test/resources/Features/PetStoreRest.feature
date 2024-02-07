Feature:  Swagger Petstore

  Scenario:  CRUD exitoso para mascota
    Given que me encuentro con la url de Pet store
    When realice el crud de los servicios relacionados a mascota
    Then validare que el codigo de estado del servicio final sea 200
