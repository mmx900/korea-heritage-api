package org.manalith.heritage

import fr.hmil.roshttp.HttpResponse
import org.manalith.heritage.Services._

import scala.xml.XML

class ServicesImpl extends Services {

  override protected def convertItems(response: HttpResponse): ListItemsResult = {
    val xml = XML.loadString(response.body)

    val items = (xml \\ "item") map { item =>
      Item(
        sn = (item \\ "sn").text.toInt,
        no = (item \\ "no").text.toInt,
        ccmaName = (item \\ "ccmaName").text,
        crltsnoNm = (item \\ "crltsnoNm").text.toInt,
        ccbaMnm1 = (item \\ "ccbaMnm1").text,
        ccbaMnm2 = (item \\ "ccbaMnm2").text,
        ccbaCtcdNm = (item \\ "ccbaCtcdNm").text,
        ccsiName = (item \\ "ccsiName").text,
        ccbaAdmin = (item \\ "ccbaAdmin").text,
        ccbaKdcd = (item \\ "ccbaKdcd").text.toInt,
        ccbaCtcd = (item \\ "ccbaCtcd").text.toInt,
        ccbaAsno = (item \\ "ccbaAsno").text,
        ccbaCncl = (item \\ "ccbaCncl").text,
        ccbaCpno = (item \\ "ccbaCpno").text
      )
    }

    ListItemsResult(
      totalCount = (xml \\ "totalCnt").text.toInt,
      pageSize = (xml \\ "pageUnit").text.toInt,
      page = (xml \\ "pageIndex").text.toInt,
      items
    )
  }
}
