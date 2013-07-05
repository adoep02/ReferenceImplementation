//
//  GroupContentProviderContentProvider.m
//
//  Created by Uni Münster on Fri Jul 05 12:05:29 CEST 2013.
//  Copyright (c) 2012 Uni-Muenster. All rights reserved.
//

#import "GroupContentProviderContentProvider.h"

@implementation GroupContentProviderContentProvider

-(id) init
{
	self = [super init];
	if (self)
	{
		dataObjectName = @"GroupEntity";
		isLocal = YES;
		remoteURL = [NSURL URLWithString: @""];
		isCacheEnabled = NO;
		isLoadAllowed = YES;
		isSaveAllowed = YES;
	}
	return self;
}

@end