import java.io.{File}

object EmptyTest extends TestBase {
  lazy val inFile = new File("integration/src/test/resources/empty.xsd")
  lazy val generated = module.process(inFile, "empty", tmp)

  "empty.scala file must not be generated" in {
    generated must not contain(new File("tmp/empty.scala"))
  }

  "empty xsd generated code must compile" in {
    (List("true"), generated) must evaluateTo(true, outdir = "./tmp")
  }
}
