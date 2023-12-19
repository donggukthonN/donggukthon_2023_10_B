package donggukthon.team10.igloo.dto.paper.request;

import lombok.Builder;

@Builder
public record WritePaperDTO(
        Long id,
        String contents,
        int design
) {}
