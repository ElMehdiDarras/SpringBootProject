package com.project.jee.darrasjee.utils;

public class PageValidator {

        private PageValidator() {
        }

        public static Integer pageNumber(Integer page) {
                return page == null || page <= 0 ? 1 : page;
        }

}
