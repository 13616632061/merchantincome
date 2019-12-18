package yzx.com.merchantincome.entity;

import java.util.List;

/**
 * Created by Administrator on 2019/12/16.
 */

public class BannerResponse extends ResultResponse{


    /**
     * result : {"list":[{"id":2,"img_url":"20191215/f764d1efbd81117ccdfa8cbecaa70b7d.jpg","url":""},{"id":1,"img_url":"20191215/e4eea01292019c1c686287de487e75e9.jpg","url":""}],"domain":"http://swoole.czxshop.com/uploads/"}
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * list : [{"id":2,"img_url":"20191215/f764d1efbd81117ccdfa8cbecaa70b7d.jpg","url":""},{"id":1,"img_url":"20191215/e4eea01292019c1c686287de487e75e9.jpg","url":""}]
         * domain : http://swoole.czxshop.com/uploads/
         */

        private String domain;
        private List<ListBean> list;

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 2
             * img_url : 20191215/f764d1efbd81117ccdfa8cbecaa70b7d.jpg
             * url :
             */

            private int id;
            private String img_url;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url =img_url;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
