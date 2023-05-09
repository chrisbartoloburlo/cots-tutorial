/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters. For OAuth2 flow, you may use `user` as both username and password when asked to login.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package examples.petstore.model


  /**
   * a User
   * A User who is purchasing from the pet store
   */
case class User(
  id: Option[Long] = None,
  username: Option[String] = None,
  firstName: Option[String] = None,
  lastName: Option[String] = None,
  email: Option[String] = None,
  password: Option[String] = None,
  phone: Option[String] = None,
  /* User Status */
  userStatus: Option[Int] = None
)

