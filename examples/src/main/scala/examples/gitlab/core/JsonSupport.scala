/**
 * GitLab API
 * An OpenAPI definition for the GitLab REST API. Few API resources or endpoints are currently included. The intent is to expand this to match the entire Markdown documentation of the API: <https://docs.gitlab.com/ee/api/>. Contributions are welcome.  When viewing this on gitlab.com, you can test API calls directly from the browser against the `gitlab.com` instance, if you are logged in. The feature uses the current [GitLab session cookie](https://docs.gitlab.com/ee/api/index.html#session-cookie), so each request is made using your account.  Instructions for using this tool can be found in [Interactive API Documentation](openapi_interactive.md). 
 *
 * The version of the OpenAPI document: v4
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package examples.gitlab.core

import examples.gitlab.model._
import org.json4s._
import sttp.client3.json4s.SttpJson4sApi
import scala.reflect.ClassTag

object JsonSupport extends SttpJson4sApi {
  def enumSerializers: Seq[Serializer[_]] = Seq[Serializer[_]]()

  private class EnumNameSerializer[E <: Enumeration: ClassTag](enum: E) extends Serializer[E#Value] {
    import JsonDSL._
    val EnumerationClass: Class[E#Value] = classOf[E#Value]

    def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), E#Value] = {
      case (t @ TypeInfo(EnumerationClass, _), json) if isValid(json) =>
        json match {
          case JString(value) => enum.withName(value)
          case value => throw new MappingException(s"Can't convert $value to $EnumerationClass")
        }
    }

    private[this] def isValid(json: JValue) = json match {
      case JString(value) if enum.values.exists(_.toString == value) => true
      case _ => false
    }

    def serialize(implicit format: Formats): PartialFunction[Any, JValue] = {
      case i: E#Value => i.toString
      }
    }

  implicit val format: Formats = DefaultFormats ++ enumSerializers ++ DateSerializers.all
  implicit val serialization: org.json4s.Serialization = org.json4s.jackson.Serialization
}
