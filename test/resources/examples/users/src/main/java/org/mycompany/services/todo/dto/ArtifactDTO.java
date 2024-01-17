package org.mycompany.services.todo.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class ArtifactDTO<T> extends ArtifactBase<T> {}
