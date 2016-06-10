package org.manalith.heritage

import fr.hmil.roshttp.{ HttpRequest, HttpResponse }
import org.manalith.heritage.Services._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * 문화재 정보 OPEN API
 * http://www.cha.go.kr/html/HtmlPage.do?pg=/publicinfo/pbinfo3_0201.jsp&mn=NS_12_05_03
 */
trait Services {

  /**
   * 문화재검색 목록
   * http://www.cha.go.kr/cha/SearchKindOpenapiList.do
   */
  def listItems: Future[ListItemsResult] =
    HttpRequest("http://www.cha.go.kr/cha/SearchKindOpenapiList.do").send().map(convertItems)

  protected def convertItems(response: HttpResponse): ListItemsResult

  /**
   * 문화재검색 상세
   * http://www.cha.go.kr/cha/SearchKindOpenapiDt.do
   */
  def getDetail = ???

  /**
   * 문화재 이미지검색
   * http://www.cha.go.kr/cha/SearchImageOpenapi.do
   */
  def listImages = ???

  /**
   * 문화재 동영상검색
   * http://www.cha.go.kr/cha/SearchVideoOpenapi.do
   */
  def listVideos = ???

  /**
   * 문화재 나레이션검색
   * http://www.cha.go.kr/cha/SearchVoiceOpenapi.do
   */
  def listVoices = ???

  /**
   * 사이버 문화재 탐방 동영상검색
   * http://www.cha.go.kr/cha/openapi/selectCyberVideoList.do
   */
  def listCyberVideos = ???

  /**
   * 문화재 통계 서비스
   * http://openapi.cha.go.kr/openapi/soap/crlts/KndCrltsService?wsdl
   */
  def listStatistics = ???

  /**
   * 문화재 위치정보
   * http://www.gis-heritage.go.kr/openapi/xmlService/spca.do
   */
  def listLocations = ???
}

object Services {

  case class ListItemsResult(totalCount: Int, pageSize: Int, page: Int, items: Seq[Item])

  /**
   * vlocName 	String 	시도명
   * @param sn        순번
   * @param no
   * @param ccmaName  문화재유형
   * @param crltsnoNm 지정호수
   * @param ccbaMnm1  문화재명
   * @param ccbaMnm2  문화재명2
   * @param ccbaCtcdNm
   * @param ccsiName
   * @param ccbaAdmin 관리자
   * @param ccbaKdcd  종목코드
   * @param ccbaCtcd  시도코드
   * @param ccbaAsno  지정번호
   * @param ccbaCncl
   * @param ccbaCpno
   */
  case class Item(
    sn: Int,
    no: Int,
    ccmaName: String,
    crltsnoNm: Int,
    ccbaMnm1: String,
    ccbaMnm2: String,
    ccbaCtcdNm: String,
    ccsiName: String,
    ccbaAdmin: String,
    ccbaKdcd: Int,
    ccbaCtcd: Int,
    ccbaAsno: String,
    ccbaCncl: String,
    ccbaCpno: String
  )
}
