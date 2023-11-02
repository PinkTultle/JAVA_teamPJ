package GUI;

// 레이블 등에서 줄바꿈을 하기 위해서 String 객체에 html 코드를 추가시키는 메소드
// String 객체와 한줄의 길이를 매개 변수로 받음

public class SwingCRLF {
	static final String lf = "<br>";

	static String CRLF(String s, int limit) { // 띄어쓰기를 기준으로 줄 바꿈
		StringBuffer temp = new StringBuffer();
		String result = "";
		int last_idx = 0, cnt_idx = 0, buff_idx = 0;
		if (s == null)
			return "";
		for (char c : s.toCharArray()) {
			if (cnt_idx == limit) {
				if (last_idx != 0) {
					temp.delete(last_idx, last_idx + 1);
					temp.insert(last_idx, lf);
					cnt_idx = buff_idx - last_idx;
					last_idx = 0;
				} else {
					temp.append(lf);
					cnt_idx = 0;
				}
				buff_idx += lf.length();
			}
			if (c == ' ')
				last_idx = buff_idx;
			buff_idx++;
			cnt_idx++;
			temp.append(c);
		}
		temp.insert(0, "<html><body>");
		temp.append("</body></html>");
		result = temp.toString();
		return result;
	}

	static String CRLF_abs(String s, int limit) { // 길이를 기준으로 줄바꿈
		StringBuffer temp = new StringBuffer();
		String result = "";
		int cnt_idx = 0;
		if (s == null)
			return "";
		for (char c : s.toCharArray()) {
			if (cnt_idx == limit) {
				temp.append(lf);
				cnt_idx = 0;
			}
			temp.append(c);
			cnt_idx++;
		}
		temp.insert(0, "<html><body>");
		temp.append("</body></html>");
		result = temp.toString();
		return result;
	}

	static String CRLF_ln(String s) { // 개행문자를 기준으로 줄바꿈
		StringBuffer temp = new StringBuffer();
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '\n')
				temp.append(lf);
			else
				temp.append(s.charAt(i));
		}
		temp.insert(0, "<html><body>");
		temp.append("</body></html>");
		result = temp.toString();
		return result;
	}
}