package com.inesv.ecchain.kernel.http;


import com.inesv.ecchain.common.util.Convert;
import com.inesv.ecchain.kernel.core.EcBlockchainImpl;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

import static com.inesv.ecchain.kernel.http.JSONResponses.INCORRECT_HEIGHT;
import static com.inesv.ecchain.kernel.http.JSONResponses.MISSING_HEIGHT;


public final class GetBlockId extends APIRequestHandler {

    static final GetBlockId instance = new GetBlockId();

    private GetBlockId() {
        super(new APITag[]{APITag.BLOCKS}, "height");
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest req) {

        int height;
        try {
            String heightValue = Convert.emptyToNull(req.getParameter("height"));
            if (heightValue == null) {
                return MISSING_HEIGHT;
            }
            height = Integer.parseInt(heightValue);
        } catch (RuntimeException e) {
            return INCORRECT_HEIGHT;
        }

        try {
            JSONObject response = new JSONObject();
            response.put("block", Long.toUnsignedString(EcBlockchainImpl.getInstance().getBlockIdAtHeight(height)));
            return response;
        } catch (RuntimeException e) {
            return INCORRECT_HEIGHT;
        }

    }

}