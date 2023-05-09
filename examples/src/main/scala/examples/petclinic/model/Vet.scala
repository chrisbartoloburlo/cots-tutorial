/**
 * Spring PetClinic
 * Spring PetClinic Sample Application.
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package examples.petclinic.model


  /**
   * Vet
   * A veterinarian.
   */
case class Vet(
  /* The first name of the vet. */
  firstName: String,
  /* The last name of the vet. */
  lastName: String,
  /* The specialties of the vet. */
  specialties: Seq[Specialty],
  /* The ID of the vet. */
  id: Int
)

