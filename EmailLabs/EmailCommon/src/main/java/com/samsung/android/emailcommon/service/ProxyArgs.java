package com.samsung.android.emailcommon.service;

public interface ProxyArgs {
    final static public String ARG_PROTOCOL = "email.proxy.protocol";
    final static public String ARG_HOST = "email.proxy.host";
    final static public String ARG_USERNAME = "email.proxy.username";
    final static public String ARG_USERID = "email.proxy.userid";
    final static public String ARG_PASSWORD = "email.proxy.password";
    final static public String ARG_CERT_PASSWORD = "email.proxy.cert.password";
    final static public String ARG_PORT = "email.proxy.port";
    final static public String ARG_SSL = "email.proxy.ssl";
    final static public String ARG_CERTS = "email.proxy.certs";
    final static public String ARG_CERTS_PATH = "email.proxy.certs.path";
    final static public String ARG_DOMAIN = "email.proxy.domain";
    final static public String ARG_TRUST_CERTS = "email.proxy.trust.certs";
    final static public String ARG_ACCOUNT_ID = "email.proxy.id.account";
    final static public String ARG_MAILBOX_ID = "email.proxy.id.mailbox";
    final static public String ARG_MAILBOX_ID_TO = "email.proxy.id.mailbox.to";
    final static public String ARG_MAILBOX_ID_FROM = "email.proxy.id.mailbox.from";
    final static public String ARG_MAILBOX_SERVER_ID_TO = "email.proxy.serverid.mailbox.to";
    final static public String ARG_MESSAGE_ID = "email.proxy.id.message";
    final static public String ARG_MESSAGE_ID_DRAFT = "email.proxy.id.message.draft";
    final static public String ARG_MAILBOX_ID_ARRAY = "email.proxy.id.array.mailbox";
    final static public String ARG_MESSAGE_ID_ARRAY = "email.proxy.id.array.message";
    final static public String ARG_ATTACHMENT_ID = "email.proxy.id.attachment";
    final static public String ARG_RUN_BACKGROUND = "email.proxy.run.background";
    final static public String ARG_WITH_MIME_DATA = "email.proxy.with.mime.data";
    final static public String ARG_SAVED_BODY = "email.proxy.saved.body";
    final static public String ARG_MEETING_RESPONSE = "email.proxy.meeting.response";
    final static public String ARG_IGNORE = "email.proxy.ignore";
    final static public String ARG_CONV_ID = "email.proxy.conv.id";
    final static public String ARG_ENABLED = "email.proxy.switch.enabled";
    final static public String ARG_EXSIST = "email.proxy.switch.exsist";
    final static public String ARG_TYPE = "email.proxy.switch.type";
    final static public String ARG_TEXT = "email.proxy.text";
    final static public String ARG_OOO = "email.proxy.ooo.list";
    final static public String ARG_DATE_FROM = "email.proxy.date.from";
    final static public String ARG_DATE_TO = "email.proxy.date.to";
    final static public String ARG_COMMAND = "email.proxy.command";
    final static public String ARG_TOTAL_MSG_COUNT = "email.proxy.count.totalmessage";
    final static public String ARG_NEW_MSG_COUNT = "email.proxy.count.newmessage";
    final static public String ARG_BYTE_ARRAY = "email.proxy.byte.array";
    final static public String ARG_ALIAS = "email.proxy.alias";
    final static public String ARG_CERT_ERROR_CODE = "email.proxy.certerrorcode";
    final static public String ARG_OLD_ALIAS = "email.proxy.old.alias";
    final static public String ARG_BACKGROUND = "email.proxy.background";
    final static public String ARG_CONV_ID_STRING = "email.proxy.conv.id.string";
    final static public String ARG_GREATER_THAN_DATE_STRING = "email.proxy.greater.than.date.string";
    final static public String ARG_LESS_THAN_DATE_STRING = "email.proxy.less.than.date.string";
    final static public String ARG_MAILBOX_NAME = "email.proxy.mailbox.name";
    final static public String ARG_ON = "email.proxy.on";
    final static public String ARG_OPTIONS_DEEP_TRAVERSAL_STRING = "email.proxy.options.deep.traversal.string";
    final static public String ARG_PARENT_MAILBOX_ID = "email.proxy.id.parent.mailbox";
    final static public String ARG_RESULT = "email.proxy.result";
    final static public String ARG_SEARCH_TEXT_STRING = "email.proxy.search.text.string";
    final static public String ARG_THREAD_ID = "email.proxy.thread.id";
    final static public String ARG_URL = "email.proxy.url";
    final static public String ARG_URI = "email.proxy.uri";
    final static public String ARG_USER_REQUEST = "email.proxy.user.request";
    final static public String ARG_BATCH_UPDATE = "email.proxy.batch.update";
    final static public String ARG_ERROR_MESSAGE = "email.proxy.error.message";
    final static public String ARG_IS_MIME_DATA = "email.proxy.is.mime.data";
    final static public String ARG_IS_SAVE_BODY = "email.proxy.is.save.body";
    final static public String ARG_LOAD_STATUS = "email.proxy.load.status";
    final static public String ARG_LOCAL_MESSAGE_ID = "email.proxy.id.local.message";
    final static public String ARG_PRUNE = "email.proxy.prune";
    final static public String ARG_RECONNECT = "email.proxy.reconnect";
    final static public String ARG_SERVER_ID_ARRAY = "email.proxy.id.array.server";
    final static public String ARG_SRC_ACCOUNT_ID = "email.proxy.id.src.account";
    final static public String ARG_SRC_MAILBOX_ID = "email.proxy.id.src.mailbox";
    final static public String ARG_SRC_MESSAGE_ID = "email.proxy.id.src.message";
    final static public String ARG_SRC_SERVER_TYPE = "email.proxy.src.server.type";
    final static public String ARG_TAG = "email.proxy.tag";
    final static public String ARG_TARGET_ACCOUNT_ID = "email.proxy.id.target.account";
    final static public String ARG_TARGET_MAILBOX_ID = "email.proxy.id.target.mailbox";
    final static public String ARG_TARGET_SERVER_TYPE = "email.proxy.target.server.type";
    final static public String ARG_TRASHBOX_ID = "email.proxy.id.trashbox";
    final static public String ARG_LEGACYPUSHTYPE = "email.proxy.legacy.push.type";

    final static public String ARG_STATUS_CODE = "email.callback.status.code";
    final static public String ARG_PROGRESS = "email.callback.progress";
    final static public String ARG_CALLBACK_TEXT = "email.callback.text";
    final static public String ARG_BAD_SYNC = "email.callback.bad.sync";
    final static public String ARG_BUNDLE = "email.callback.bundle";
    final static public String ARG_SUBJECT = "email.callback.subject";
    final static public String ARG_DRAFT_ID = "email.callback.id.draft";
    final static public String ARG_SUCCESS = "email.callback.success";
    final static public String ARG_EXCEPTION_STRING = "email.callback.exception.string";

    final static public String ARG_ENC_TYPE = "email.encrypt.type";
    final static public String ARG_PGP_KEY = "email.pgp.key";
    final static public String ARG_PARENT_SERVER_ID = "email.callback.parentserverid";

    final static public String ARG_PGP_KEY_ID = "email.pgp.key.id";
    final static public String ARG_PGP_KEY_ID_ARRAY = "email.pgp.key.id.array";
    final static public String ARG_PGP_RING_KEY_ID = "email.pgp.ring.key.id";
    final static public String ARG_PGP_RING_KEY_ID_ARRAY = "email.pgp.ring.key.id.array";
    final static public String ARG_PGP_KEY_DESC = "email.pgp.key.desc";
    final static public String ARG_PGP_KEY_ALGO = "email.pgp.key.algo";
    final static public String ARG_PGP_KEY_LENGTH = "email.pgp.key.length";
    final static public String ARG_PGP_KEY_EXPIRY = "email.pgp.key.expiry";
    final static public String ARG_PGP_KEY_BREV = "email.pgp.key.brev";
    final static public String ARG_PGP_KEY_PRINT = "email.pgp.key.print";
    final static public String ARG_PGP_KEY_VALID = "email.pgp.key.valid";
    final static public String ARG_PGP_KEY_INFO_TYPE = "email.pgp.key.info.type";
    final static public String ARG_OLD_VALUE = "email.old.value";
    final static public String ARG_NEW_VALUE = "email.new.value";
    final static public String ARG_KEY_STORE_PASS = "email.key.store_pass";

    final static public String ARG_CERT_KEY_CNT = "email.cert.key.cnt";
    final static public String ARG_CERT_KEY_ADDR = "email.cert.key.addr";
    final static public String ARG_CERT_KEY_MSG = "email.cert.key.msg";
    final static public String ARG_CERT_KEY_STAT = "email.cert.key.status";

    final static public String ARG_CERT_MAIL_ADDR = "email.cert.mail.addr";
    final static public String ARG_CHECK_ALIAS_RESULT = "email.cert.check.alias";

    final static public String ARG_CERT_REMOVED_CNT = "email.cert.remove.cnt";

    final static public String VIEW_SAVE_EMAIL_RESULT = "email.view.savedemail.result";
    final static public String VIEW_SAVE_EMAIL_RESULT_FIMENAME = "email.view.savedemail.result.filename";
    final static public String ARG_OPAQUE_SIGNED = "email.smime.sign.type";

    final static public String ARG_IT_POLICY = "email.it.policy";
}
