package org.antitech.sgir

trait SoapCred {
  val uName: String = "sendoutcards\\aaron"
  val password: String = "socprint"
  // The Document ID's. Attached to the Ind Template.
  val twoPanel: String = "125"
  val threePanel: String = "128"
  val postcard: String = "129"
  // The Datasource ID's for each database connection.
  val twoPdataSource: String = "135"
  val threePdataSource: String = "136"
  val postCdataSource: String = "137"
  // Plan ID's
  val twoPanelPlan: String = "34"
  val threePanelPlan: String = "35"
  val postcardPlan: String = "36"

  def getPlan(cardType: String): String = {
    cardType match {
      case "2panel" => twoPanelPlan
      case "3panel" => threePanelPlan
      case "postcard" => postcardPlan
    }
  }

  def getDocumentId(cardType: String): String = {
    cardType match {
      case "2panel" => twoPanel
      case "3panel" => threePanel
      case "postcard" => postcard
    }
  }

  def getDataSourceId(cardType: String): String = {
    cardType match {
      case "2panel" => twoPdataSource
      case "3panel" => threePdataSource
      case "postcard" => postCdataSource
    }
  }
}