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
package examples.sockshop.core

import examples.sockshop.model._
import org.json4s._
import sttp.client3.json4s.SttpJson4sApi
import scala.reflect.ClassTag

object JsonSupport extends SttpJson4sApi {
  def enumSerializers: Seq[Serializer[_]] = Seq[Serializer[_]]()

  private class EnumNameSerializer[E <: Enumeration: ClassTag](enumeration: E) extends Serializer[E#Value] {
    import JsonDSL._
    val EnumerationClass: Class[E#Value] = classOf[E#Value]

    def deserialize(implicit formats: Formats): PartialFunction[(TypeInfo, JValue), E#Value] = {
      case (t @ TypeInfo(EnumerationClass, _), json) if isValid(json) =>
        json match {
          case JString(value) => enumeration.withName(value)
          case value => throw new MappingException(s"Can't convert $value to $EnumerationClass")
        }
    }

    private[this] def isValid(json: JValue) = json match {
      case JString(value) if enumeration.values.exists(_.toString == value) => true
      case _ => false
    }

    def serialize(implicit formats: Formats): PartialFunction[Any, JValue] = {
      case i: E#Value => i.toString
      }
    }

  implicit val formats: Formats = DefaultFormats ++ enumSerializers ++ DateSerializers.all ++ AdditionalTypeSerializers.all
  implicit val serialization: org.json4s.Serialization = org.json4s.jackson.Serialization
}
