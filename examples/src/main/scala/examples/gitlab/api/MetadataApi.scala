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
package examples.gitlab.api

import examples.gitlab.model.MetadataResponse
import examples.gitlab.core.JsonSupport._
import sttp.client3._
import sttp.model.Method

object MetadataApi {

def apply(baseUrl: String = "http://localhost/api") = new MetadataApi(baseUrl)
}

class MetadataApi(baseUrl: String) {

  /**
   * Expected answers:
   *   code 401 :  (unauthorized operation)
   *   code 200 : MetadataResponse (successful operation)
   * 
   * Available security schemes:
   *   ApiKeyAuth (apiKey)
   */
  def getMetadata(apiKey: String, 
): Request[Either[ResponseException[String, Exception], MetadataResponse], Any] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/v4/metadata")
      .contentType("application/json")
      .header("Private-Token", apiKey)
.response(asJson[MetadataResponse])

}
