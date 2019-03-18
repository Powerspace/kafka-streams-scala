import sbt._

//Required in order to not have difficulties to download transient dependency 
// [javax.ws.rs#javax.ws.rs-api;2.1!javax.ws.rs-api.jar(src)]
object PackagingTypePlugin extends AutoPlugin {
  override val buildSettings = {
    sys.props += "packaging.type" -> "jar"
    Nil
  }
}