package com.askominas.pastebinandroid.api

const val BASE_URL = "https://pastebin.com/"
const val API_DEV_KEY = "d2f23fc15c712b08b57482e45c27fbe8"

const val GET_PASTE_ENDPOINT = "raw/{pasteId}"
const val POST_PASTE_ENDPOINT = "api/api_post.php"
const val POST_LOGIN_ENDPOINT = "api/api_login.php"

const val API_DEV_KEY_FIELD = "api_dev_key"
const val API_OPTION_FIELD = "api_option"
const val API_PASTE_CODE_FIELD = "api_paste_code"
const val API_USER_NAME_FIELD = "api_user_name"
const val API_USER_PASSWORD_FIELD = "api_user_password"

const val API_OPTION_FIELD_PASTE = "paste"

const val API_ERROR_INVALID_LOGIN = "Bad API request, invalid login"
const val API_ERROR_INVALID_POST = "Bad API request, invalid POST parameters"
