package com.example.shop.core.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    //common
    INVALID_INPUT_VALUE(400, "C001", "올바르지 않은 형식입니다"),
    METHOD_NOT_ALLOWED(405, "C002", "지원하지 않는 메소드입니다."),
    ENTITY_NOT_FOUND(400, "C003", "해당 엔티티를 찾을 수가 없습니다."),
    INTERNAL_SERVER_ERROR(500, "c004", "알 수 없는 에러 발생(서버에러)"),
    INVALID_TYPE_VALUE(400, "C005", "타입이 올바르지 않습니다."),
    HANDLE_ACCESS_DENIED(403, "C006", "권한이 없습니다"),
    HANDLE_INVALID__TOKEN(401, "C007", "토큰이 없거나 올바르지 않습니다"),
    NOT_MY_ENTITY(400, "C008", "내 작성물이 아닙니다"),
    OVER_TIME(400, "C009", "수정 및 삭제는 등록 후 1시간 이내에만 가능합니다."),

    //AUTH
    NOT_MATCH_UID(400, "A001", "올바르지 않은 아이디 입니다."),

    //Member
    USERID_DUPLICATION(400, "M001", "존재하는 아이디 입니다."),
    PHONENUM_DUPLICATION(400, "M002", "이 번호로 이미 가입 되었습니다"),
    PASSWORD_INPUT_INVALID(400,  "M003", "비밀번호를 확인 해주세요"),
    CHECK_USER_INVALID(400, "M004", "해당 정보에 맞는 유저가 없습니다."),
    USER_NOT_MATCH(400, "M005", "유저 정보가 맞지 않습니다"),

    //FILE
    FILE_NOT_FOUND(400, "R001", "해당 파일을 찾을 수가 없습니다."),
    FILE_SAVE_ERROR(400, "R001", "파일 저장에 실패하였습니다."),

    //Board
    BOARD_NOT_FOUND(400, "B001", "해당 게시글을 찾을 수 없습니다."),

    //Comment
    COMMENT_NOT_FOUND(400, "F001", "해당 댓글을 찾을 수 없습니다.")

    ;


    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
