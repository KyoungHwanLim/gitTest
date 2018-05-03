package user.service;

import user.model.UserVO;

/**
 * 
* UserServiceInf.java
*
* @author "L.K.H"
* @since 2018. 4. 13.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 4. 13. "L.K.H" 최초 생성
*
* </pre>
 */
public interface UserServiceInf {
	/**
	 * 
	* Method : loginProcess
	* 최초작성일 : 2018. 4. 13.
	* 작성자 : "L.K.H"
	* 변경이력 :
	* @param userVO
	* @return
	* Method 설명 :
	 */
	public boolean loginProcess(UserVO userVO);
}
