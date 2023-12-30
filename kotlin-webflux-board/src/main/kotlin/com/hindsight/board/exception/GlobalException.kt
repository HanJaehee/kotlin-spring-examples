package com.hindsight.board.exception

class GlobalException(val globalMessage: GlobalMessage): RuntimeException(globalMessage.message)