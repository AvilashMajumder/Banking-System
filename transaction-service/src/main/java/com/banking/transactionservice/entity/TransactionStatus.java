package com.banking.transactionservice.entity;

/**
 * Transaction Lifecycle Flow:
 *
 * Pending -> Processing -> Completed (clean transaction)
 * Pending -> Processing -> Pending_Verification (suspicious detected)
 *                              -> Completed (Verified)
 *                              -> Flagged (SAGA Refund)
 *                       -> Failed
 *                       -> Flagged
 */
public enum TransactionStatus {

    PENDING,
    PROCESSING,
    PENDING_VERIFICATION,
    COMPLETED,
    FAILED,
    FLAGGED
}
