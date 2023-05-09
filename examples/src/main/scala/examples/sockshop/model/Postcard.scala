/**
 * User
 * Provide Customer login, register, retrieval, as well as card and address retrieval
 *
 * The version of the OpenAPI document: 
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package examples.sockshop.model


case class Postcard(
  /* Credit card number */
  longNum: Option[String] = None,
  /* Card expiration */
  expires: Option[String] = None,
  /* Card ccv */
  ccv: Option[String] = None,
  /* User to attach this card to. */
  userID: Option[String] = None
)

