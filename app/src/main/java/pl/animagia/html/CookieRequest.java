package pl.animagia.html;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookieRequest extends StringRequest {

    // Since we're extending a Request class
    // we just use its constructor
    public CookieRequest(int method, String url,
                         Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    private Map<String, String> headers = new HashMap<>();

    /**
     * Custom class!
     */
    public void setCookies(String cookies) {
//        StringBuilder sb = new StringBuilder();
//        for (String cookie : cookies) {
//            sb.append(cookie).append("; ");
//        }
        headers.put("Cookie", cookies);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers;
    }

}