package com.fabiopereira.email;

import java.util.UUID;

public record EmailRecord(
        UUID userId,
        String emailTo,
        String subject,
        String text
) {
}
