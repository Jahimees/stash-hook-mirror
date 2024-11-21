package com.englishtown.bitbucket.hook;

import com.atlassian.bitbucket.repository.Repository;

import java.io.Serializable;

class MirrorRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int repositoryId;
    private final MirrorSettings settings;

    MirrorRequest(Repository repository, MirrorSettings settings) {
        this(repository.getId(), settings);
    }

    MirrorRequest(int repositoryId, MirrorSettings settings) {
        this.repositoryId = repositoryId;
        this.settings = settings;
    }

    int getRepositoryId() {
        return repositoryId;
    }

    MirrorSettings getSettings() {
        return settings;
    }

    public String toString() {
        return repositoryId + ":" + settings.mirrorRepoUrl;
    }
}
