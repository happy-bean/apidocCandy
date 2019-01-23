define({ "api": [
 {
    "type": "POST",
    "url": "/Appjsonpublic/register",
    "title": "1.1 注册",
    "group": "1）登陆注册",
    "parameter": {
      "fields": {
        "Parameter": [
         {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "verify",
            "description": "<p>验证码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "http://api.esouche.cn/Appjsonpublic/register"
      }
    ],
    "version": "1.0.0",
    "filename": "",
    "groupTitle": "1）登陆注册",
    "name": "PostAppjsonregister"
  },
 ] });
