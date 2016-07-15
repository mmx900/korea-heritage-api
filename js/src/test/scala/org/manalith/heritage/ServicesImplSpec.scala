package org.manalith.heritage

import org.scalatest.AsyncFreeSpec

import scala.concurrent.ExecutionContext

class ServicesImplSpec extends AsyncFreeSpec {

  override implicit val executionContext = ExecutionContext.Implicits.global

  val servicesImpl = new ServicesImpl

  "listItems" - {
    val listItems = servicesImpl.listItems

    "should return valid values" in {
      listItems map { list =>
        assert(list.totalCount > 14579) // 테스트 작성 시점의 totalCount
        assert(list.pageSize == 10)
        assert(list.page == 1)
        assert(list.items.size == 10)

        val item = list.items.head
        assert(item.sn == 1)
        assert(item.no == 1)
        assert(item.ccmaName == "국보")
        assert(item.crltsnoNm == 1)
        assert(item.ccbaMnm1 == "서울 숭례문")
        assert(item.ccbaMnm2 == "서울 崇禮門")
        assert(item.ccbaCtcdNm == "서울")
        assert(item.ccsiName == "중구")
        assert(item.ccbaAdmin == "문화재청 숭례문관리소")
        assert(item.ccbaKdcd == 11)
        assert(item.ccbaCtcd == 11)
        assert(item.ccbaAsno == "00010000")
        assert(item.ccbaCncl == "N")
        assert(item.ccbaCpno == "1111100010000")
      }
    }
  }
}
