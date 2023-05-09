/**
 * cwa-verification-server
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.5.0-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package examples.cwa.api

import examples.cwa.model.RegistrationToken
import examples.cwa.model.Tan
import examples.cwa.core.JsonSupport._
import sttp.client3._
import sttp.model.Method

object ExternalTanControllerApi {

def apply(baseUrl: String = "http://localhost:8080") = new ExternalTanControllerApi(baseUrl)
}

class ExternalTanControllerApi(baseUrl: String) {

  /**
   * Generates a TAN on input of Registration Token. With the TAN one can submit his Diagnosis keys
   * 
   * Expected answers:
   *   code 500 :  (Internal Server Error)
   *   code 400 :  (Registration Token does not exist)
   *   code 405 :  (Method Not Allowed)
   *   code 415 :  (Unsupported Media Type)
   *   code 201 : Tan (Registration Token is valid)
   * 
   * @param registrationToken 
   * @param cwaFake 
   */
  def generateTan(registrationToken: RegistrationToken, cwaFake: Option[String] = None
): Request[Either[ResponseException[String, Exception], Tan], Any] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/version/v1/tan")
      .contentType("application/json")
      .header("cwa-fake", cwaFake.toString)
      .body(registrationToken)
      .response(asJson[Tan])

}
