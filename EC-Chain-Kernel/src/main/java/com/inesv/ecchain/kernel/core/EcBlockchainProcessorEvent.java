package com.inesv.ecchain.kernel.core;


public enum EcBlockchainProcessorEvent {
    BLOCK_PUSHED, BLOCK_POPPED, BLOCK_GENERATED, BLOCK_SCANNED,
    RESCAN_BEGIN, RESCAN_END,
    BEFORE_BLOCK_ACCEPT, AFTER_BLOCK_ACCEPT,
    BEFORE_BLOCK_APPLY, AFTER_BLOCK_APPLY
}
