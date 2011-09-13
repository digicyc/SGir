package antitech.sgir

import com.sendoutcards.socprint._
import datasourceplanutils.{DataSourcePlanUtilsSSPSoap, DataSourcePlanUtilsSSP,
RecipientsInfo}
import planutils.{PlanUtilsSSPSoap, PlanUtilsSSP, PlanFilter}

class SocPrint extends SoapCred {
  private lazy val statChecker: DataSourcePlanUtilsSSPSoap =
    (new DataSourcePlanUtilsSSP()).getDataSourcePlanUtilsSSPSoap()
  private lazy val planUtils: PlanUtilsSSPSoap =
    (new PlanUtilsSSP()).getPlanUtilsSSPSoap()

  def getFilters(cardType: String): List[PlanFilter] = {
    val planID: String = getPlan(cardType)
    val documentId: String = getDocumentId(cardType)
    val planId = getPlan(cardType)
    val planFilters = planUtils.getFilters(uName, password,
      planId, false).getPlanFilter

    planFilters.toArray.toList.asInstanceOf[List[PlanFilter]]
  }

  def getStat(filterName: String, cardType: String): String = {
    val documentId = getDocumentId(cardType)
    val planId = getPlan(cardType)
    val dataSourceId = getDataSourceId(cardType)

    val riInfo: RecipientsInfo = new RecipientsInfo()
    riInfo.setMFilterType(2)
    riInfo.setMFilter(filterName)

    statChecker.getRecipientsCount(uName, password,
      planId, dataSourceId, riInfo).toString()
  }

  // Get Production Stats from Plan File.
  def getStats(reqPanel: String): List[(String, String)] = {
    val twoPanels: List[PlanFilter] = getFilters("2panel")
    val threePanels: List[PlanFilter] = getFilters("3panel")
    val postCards: List[PlanFilter] = getFilters("postcard")


    reqPanel match {
      case "2panel" =>
        for {
          filterName <- twoPanels
          statInfo = getStat(filterName.getMName, "2panel")
        } yield (filterName.getMName, statInfo)
      case "3panel" =>
        for {
          filterName <- threePanels
          statInfo = getStat(filterName.getMName, "3panel")
        } yield (filterName.getMName, statInfo)
      case "postcard" =>
        for {
          filterName <- postCards
          statInfo = getStat(filterName.getMName, "postcard")
        } yield (filterName.getMName, statInfo)
      case _ => List(("NA", "0"))
    }
  }
}
