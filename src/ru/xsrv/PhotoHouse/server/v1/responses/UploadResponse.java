package ru.xsrv.PhotoHouse.server.v1.responses;

import ru.xsrv.PhotoHouse.model.types.UploadData;

/**
 *
 * Created by calc on 03.11.14.
 */
public class UploadResponse extends Response {
    private String upload;

    private UploadData upload_data;

    @Override
    protected String getStatus() {
        return upload;
    }

    public UploadData getUploadData() {
        return upload_data;
    }
}
