package ch.makery.address

import javafx.fxml.FXMLLoader
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes.*
import javafx.scene as jfxs

object MainApp extends JFXApp3:

  //Window Root Pane
  var roots: Option[scalafx.scene.layout.BorderPane] = None

  override def start(): Unit =
    // transform path of RootLayout.fxml to URI for resource location.
    val rootResource = getClass.getResource("view/RootLayout.fxml")
    // initialize the loader object.
    val loader = new FXMLLoader(rootResource) // Read all the object
    // Load root layout from fxml file.
    loader.load() // If error then throw error

    // retrieve the root component BorderPane from the FXML : Border pane contain everything
    roots = Option(loader.getRoot[jfxs.layout.BorderPane]) // jfxs: java fxscene

    stage = new PrimaryStage():
      title = "AddressApp"
      scene = new Scene():
        root = roots.get

    // call to display PersonOverview when app start
    showPersonOverview()
  // actions for display person overview window
  def showPersonOverview(): Unit =
    val resource = getClass.getResource("view/PersonOverview.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane] // javafx anchorpane
    this.roots.get.center = roots
