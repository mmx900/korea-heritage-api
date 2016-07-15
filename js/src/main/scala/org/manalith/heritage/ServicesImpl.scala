package org.manalith.heritage

import fr.hmil.roshttp.HttpResponse
import org.manalith.heritage.Services._
import org.querki.jquery._

class ServicesImpl extends Services {

  override protected def convertItems(response: HttpResponse): ListItemsResult = {
    val xml = $($.parseXML(response.body)).children("result")

    val items = xml.children("item") mapElems { item =>
      val i = $(item)

      Item(
        sn = i.children("sn").text.toInt,
        no = i.children("no").text.toInt,
        ccmaName = i.children("ccmaName").text,
        crltsnoNm = i.children("crltsnoNm").text.toInt,
        ccbaMnm1 = i.children("ccbaMnm1").text,
        ccbaMnm2 = i.children("ccbaMnm2").text,
        ccbaCtcdNm = i.children("ccbaCtcdNm").text,
        ccsiName = i.children("ccsiName").text,
        ccbaAdmin = i.children("ccbaAdmin").text,
        ccbaKdcd = i.children("ccbaKdcd").text.toInt,
        ccbaCtcd = i.children("ccbaCtcd").text.toInt,
        ccbaAsno = i.children("ccbaAsno").text,
        ccbaCncl = i.children("ccbaCncl").text,
        ccbaCpno = i.children("ccbaCpno").text
      )
    }

    ListItemsResult(
      totalCount = xml.children("totalCnt").text.toInt,
      pageSize = xml.children("pageUnit").text.toInt,
      page = xml.children("pageIndex").text.toInt,
      items
    )
  }
}
