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
package examples.petstore.api

import examples.petstore.model.ApiResponse
import java.io.File
import examples.petstore.model.Pet
import examples.petstore.core.JsonSupport._
import sttp.client3._
import sttp.model.Method

object PetApi {

def apply(baseUrl: String = "http://localhost:8080/v3") = new PetApi(baseUrl)
}

class PetApi(baseUrl: String) {

  /**
   * Expected answers:
   *   code 405 :  (Invalid input)
   * 
   * @param pet Pet object that needs to be added to the store
   */
  def addPet(pet: Pet
): Request[Either[ResponseException[String, Exception], Unit], Any] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/pet")
      .contentType("application/json")
      .body(pet)
      .response(asJson[Unit])

  /**
   * Expected answers:
   *   code 400 :  (Invalid pet value)
   * 
   * @param apiKey 
   * @param petId Pet id to delete
   */
  def deletePet(apiKey: String, petId: Long
): Request[Either[ResponseException[String, Exception], Unit], Any] =
    basicRequest
      .method(Method.DELETE, uri"$baseUrl/pet/${petId}")
      .contentType("application/json")
      .header("api_key", apiKey.toString)
      .response(asJson[Unit])

  /**
   * Multiple status values can be provided with comma separated strings
   * 
   * Expected answers:
   *   code 200 : Seq[Pet] (successful operation)
   *   code 400 :  (Invalid status value)
   * 
   * @param status Status values that need to be considered for filter
   */
  def findPetsByStatus(status: Seq[String]
): Request[Either[ResponseException[String, Exception], Seq[Pet]], Any] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/pet/findByStatus?status=${ status }")
      .contentType("application/json")
      .response(asJson[Seq[Pet]])

  /**
   * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
   * 
   * Expected answers:
   *   code 200 : Seq[Pet] (successful operation)
   *   code 400 :  (Invalid tag value)
   * 
   * @param tags Tags to filter by
   */
  def findPetsByTags(tags: Seq[String]
): Request[Either[ResponseException[String, Exception], Seq[Pet]], Any] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/pet/findByTags?tags=${ tags }")
      .contentType("application/json")
      .response(asJson[Seq[Pet]])

  /**
   * Returns a single pet
   * 
   * Expected answers:
   *   code 200 : Pet (successful operation)
   *   code 400 :  (Invalid ID supplied)
   *   code 404 :  (Pet not found)
   * 
   * Available security schemes:
   *   api_key (apiKey)
   * 
   * @param petId ID of pet to return
   */
  def getPetById(apiKey: String, petId: Long
): Request[Either[ResponseException[String, Exception], Pet], Any] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/pet/${petId}")
      .contentType("application/json")
      .header("api_key", apiKey)
      .response(asJson[Pet])

  /**
   * Expected answers:
   *   code 400 :  (Invalid ID supplied)
   *   code 404 :  (Pet not found)
   *   code 405 :  (Validation exception)
   * 
   * @param pet Pet object that needs to be added to the store
   */
  def updatePet(pet: Pet
): Request[Either[ResponseException[String, Exception], Unit], Any] =
    basicRequest
      .method(Method.PUT, uri"$baseUrl/pet")
      .contentType("application/json")
      .body(pet)
      .response(asJson[Unit])

  /**
   * Expected answers:
   *   code 405 :  (Invalid input)
   * 
   * @param petId ID of pet that needs to be updated
   * @param name Updated name of the pet
   * @param status Updated status of the pet
   */
  def updatePetWithForm(petId: Long, name: Option[String] = None, status: Option[String] = None
): Request[Either[ResponseException[String, Exception], Unit], Any] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/pet/${petId}")
      .contentType("application/x-www-form-urlencoded")
      .body(Map(
        "name" -> name,
        "status" -> status
      ))
      .response(asJson[Unit])

  /**
   * Expected answers:
   *   code 200 : ApiResponse (successful operation)
   * 
   * @param petId ID of pet to update
   * @param additionalMetadata Additional data to pass to server
   * @param file file to upload
   */
  def uploadFile(petId: Long, additionalMetadata: Option[String] = None, file: Option[File] = None
): Request[Either[ResponseException[String, Exception], ApiResponse], Any] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/pet/${petId}/uploadImage")
      .contentType("multipart/form-data")
      .multipartBody(Seq(
                additionalMetadata.map(multipart("additionalMetadata", _))
, 
                file.map(multipartFile("file", _))

      ).flatten)
      .response(asJson[ApiResponse])

}
